package secao16.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import secao16.boardgame.Board;
import secao16.boardgame.Piece;
import secao16.boardgame.Position;
import secao16.chess.pieces.Bishop;
import secao16.chess.pieces.King;
import secao16.chess.pieces.Knight;
import secao16.chess.pieces.Pawn;
import secao16.chess.pieces.Queen;
import secao16.chess.pieces.Rook;

public class ChessMatch {

	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;
	private ChessPiece enPassantVulnarable;
	private ChessPiece promoted;

	private List<Piece> piecesOnTheBoard = new ArrayList<>(); 
	private List<Piece> capturedPieces = new ArrayList<>(); 
	
	public ChessMatch() {
		board = new Board(8, 8);	// Construtor instanciando a classe board e dizendo que o tabuleiro deve isinializar com tamanho 8 x 8
		turn = 1;
		currentPlayer = Color.GREEN;
		check = false;
		checkMate = false;
		
		initialSetup(); 			// Chamada de metodo para iniciar a partida carregando as peças no tabuleiro criado
	}
	
	
	// METODOS GETTERS / SETTERS
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer; 
	}
	
	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}
	
	public ChessPiece enPassantVulnarable() {
		return enPassantVulnarable;
	}
	
	public ChessPiece promoted() {
		return promoted;
	}
	

	// METODOS DE PROCESSAMENTO
	public ChessPiece[][] getPieces() {	// Retorna matriz de peças conrrespondente a partida 
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];	// Crio uma matriz de tipo chesspiece com tamanho de linha/coluna
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);	// enviando a peça(board.piece) para amatriz porem preciso converter essa peça em uma chesspiece porque é a peça da partida
			}
		}
		
		return mat; 
	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPositon();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPositon();
		Position target = targetPosition.toPositon();
		
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source,target);
		
		// testagem para ver se o movimento colocou o jogador em CHECK
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check. (Press ENTER)");
		}
		
		ChessPiece movedPiece = (ChessPiece)board.piece(target); 
		
		// Tratamento para jogada promoção
		promoted = null;
		if ( movedPiece instanceof Pawn ) {
			if ( (movedPiece.getColor() == Color.WHITE && target.getRow() == 0) || (movedPiece.getColor() == Color.BLACK && target.getRow() == 7) ) {	// Se peça branca/preta e posição zero/sete da matriz, chegou no final do tabuleiro
				promoted = (ChessPiece)board.piece(target);
				promoted = replacePromotedPiece("Q");
			}
		}
		
		// Testagem de CHECK
		check = (testCheck(opponent(currentPlayer))) ? true : false;

		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		}
		else {
			nextTurn();
		}
		
		// Tratamento para analisar en Passant
		if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 || target.getRow() == source.getRow() + 2)) {
			enPassantVulnarable = movedPiece;
		}
		else {
			enPassantVulnarable = null;
		}
		
		return (ChessPiece)capturedPiece;
	}
	
	public ChessPiece replacePromotedPiece(String type) {
		if (promoted == null) {
			throw new IllegalStateException("There is no piece on promoted. (Press ENTER)");
		}
		if (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
			return promoted;
		}
		
		Position pos = promoted.getChessPosition().toPositon();
		Piece p = board.removePiece(pos);
		piecesOnTheBoard.remove(p);
		
		ChessPiece newPiece = newPiece(type, promoted.getColor());
		board.placePiece(newPiece, pos);
		piecesOnTheBoard.add(newPiece);
		
		return newPiece;
	}
	
	private ChessPiece newPiece(String type, Color color) {
		if ( type.equals("B")) return new Bishop(board, color);
		if ( type.equals("N")) return new Knight(board, color);
		if ( type.equals("Q")) return new Queen(board, color);
		if ( type.equals("R")) return new Rook(board, color);
		return new Rook(board, color);
	}

	private Piece makeMove(Position source, Position target) {
		ChessPiece p = (ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		// MOVIMENTOS ESPECIAIS - Castling kingside rook 
		if (p instanceof King && target.getColumn() == source.getColumn() + 2) { // Se peça movimentada é o rei e andou 2 casa para direita
			Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
			Position targetT = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}
		// MOVIMENTOS ESPECIAIS - Castling queenside rook 
		if (p instanceof King && target.getColumn() == source.getColumn() - 2) { // Se peça movimentada é o rei e andou 2 casa para esquerda
			Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
			Position targetT = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}
		
		// MOVIMENTO ESPECIAL EN PASSANT
		if ( p instanceof Pawn ) {
			if ( source.getColumn() != target.getColumn() && capturedPiece == null ) {	// Se andou na diagonal e nao capturou peça é um EN PASSANT
				Position pawnPosition;
				if ( p.getColor() == Color.WHITE ) {
					pawnPosition = new Position(target.getRow() + 1, target.getColumn());
				}
				else {
					pawnPosition = new Position(target.getRow() - 1, target.getColumn());
				}

				capturedPiece = board.removePiece(pawnPosition);
				capturedPieces.add(capturedPiece);
				piecesOnTheBoard.remove(capturedPiece);
			}
		}
		
		return capturedPiece;
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		ChessPiece p = (ChessPiece)board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);
		
		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
		
		// MOVIMENTOS ESPECIAIS - Castling kingside rook 
		if (p instanceof King && target.getColumn() == source.getColumn() + 2) { // Se peça movimentada é o rei e andou 2 casa para direita
			Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
			Position targetT = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece)board.removePiece(targetT);
			board.placePiece(rook, sourceT);
			rook.decreaseMoveCount();
		}
		// MOVIMENTOS ESPECIAIS - Castling queenside rook 
		if (p instanceof King && target.getColumn() == source.getColumn() - 2) { // Se peça movimentada é o rei e andou 2 casa para esquerda
			Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
			Position targetT = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece)board.removePiece(targetT);
			board.placePiece(rook, sourceT);
			rook.decreaseMoveCount();
		}
		
		// MOVIMENTO ESPECIAL EN PASSANT
		if ( p instanceof Pawn ) {
			if ( source.getColumn() != target.getColumn() && capturedPiece == enPassantVulnarable ) {	// Se andou na diagonal e capturou peça foi um EN PASSANT
				
				ChessPiece pawn = (ChessPiece)board.removePiece(target);
				Position pawnPosition;
				if ( p.getColor() == Color.WHITE ) {
					pawnPosition = new Position(3, target.getColumn());
				}
				else {
					pawnPosition = new Position(4, target.getColumn());
				}
				
				board.placePiece(pawn, pawnPosition);
			}
		}
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position. (Press ENTER)");
		}
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The Chosen piece is not yours. (Press ENTER)");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {	// testando se existe algum movimento possivel 
			throw new ChessException("There is no possible moves to the choice piece. (Press ENTER)");
		}
	}

	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("There chosen piece can't move to target position. (Press ENTER)");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.GREEN) ? Color.BLACK : Color.GREEN;
	}

	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChessPiece King(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList()); // Filtrando uma lista usando expressão lambda
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("There is no " + color + " king on the board. (Press ENTER)");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = King(color).getChessPosition().toPositon(); // pego posição do meu rei na posição de xadrez
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());	//Pegou as peças do oponente
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();	// armazena no array mat as possiveis movimentações das peças do oponente
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) { // se a posição do rei estiver nos movimentos possiveis das peças do adversarios entao é um CHECK
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {	// Se essa cor não estiver em check, tbm não esta em checkMate
			return false;
		}
		
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMoves();	// armazena no array mat as possiveis movimentações das peças
			for (int i = 0; i < board.getRows(); i++) {
				 for (int j = 0; j < board.getColumns(); j++) {
					 if (mat[i][j]) {
						 Position source = ((ChessPiece)p).getChessPosition().toPositon();
						 Position target = new Position(i, j);
						 
						 Piece capturedPiece = makeMove(source, target);
						 boolean testCheck = testCheck(color);
						 undoMove(source, target, capturedPiece);
						 if (!testCheck) {
							return false;
						 }
					 }
				}
			}
			
			
		}
		return true;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPositon());
		piecesOnTheBoard.add(piece);
	}
	
	// Metodo responsavel por iniciar a partida de xadrez colocando as peças no tabuleiro
	private void initialSetup() {
		
		// Iniciando peças Brancas
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));		// Colocando uma torre de cor branca na posição especificada
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('d', 1, new Queen(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.WHITE, this));
		placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));
		placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
		placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));
		
		// Iniciando peças Pretas
		placeNewPiece('a', 8, new Rook(board, Color.BLACK));		// Colocando uma torre de cor branca na posição especificada
		placeNewPiece('b', 8, new Knight(board, Color.BLACK));
		placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('d', 8, new Queen(board, Color.BLACK));
		placeNewPiece('e', 8, new King(board, Color.BLACK, this));
		placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('g', 8, new Knight(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.BLACK));
		placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
		placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));

	}
}
 