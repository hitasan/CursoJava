package secao16.chess.pieces;

import secao16.boardgame.Board;
import secao16.boardgame.Position;
import secao16.chess.ChessMatch;
import secao16.chess.ChessPiece;
import secao16.chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	// METODOS CONSTRUTORES
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	
	// DEMAIS METODOS
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {				// Metodo que indica se o rei poderá ser movido para a posição recebida no parametro
		ChessPiece p = (ChessPiece)getBoard().piece(position);	// pego a peça que estiver na posição
		return p == null || p.getColor() != getColor();			// retorno se pode mover para uma casa vazia ou se tem uma peça adversaria
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento ACIMA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento ABAIXO
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento ESQUERDA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow(), position.getColumn() - 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento DIREITA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow(), position.getColumn() + 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento DIAGONAL ACIMA ESQUERDA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1 , position.getColumn() - 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento DIAGONAL ACIMA DIREITA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1 , position.getColumn() + 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento DIAGONAL ABAIXO ESQUERDA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1 , position.getColumn() - 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento DIAGONAL ABAIXO DIREITA
		//--------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1 , position.getColumn() + 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//--------------------------------------------------------------------------------------------------------------------------------------------
		// Movimento Especial Castling
		//--------------------------------------------------------------------------------------------------------------------------------------------
		if ( getMoveCount() == 0 && !chessMatch.getCheck() ) {	// se nao existe movimento do rei e o mesmo nao esta em check
			// kingside rook
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if ( testRookCastling(posT1) ) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if ( getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
				
			}
			
			// Queenside rook
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if ( testRookCastling(posT2) ) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if ( getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
				
			}
		}
		
		
		
		return mat;
	}
	
	

}
