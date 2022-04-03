package secao16.chess;

import secao16.boardgame.Board;
import secao16.boardgame.Piece;
import secao16.boardgame.Position;

public abstract class ChessPiece extends Piece {

	// ATRIBUTOS DA CLASSE
	private Color color;
	private int moveCount;


	// METODOS CONSTRUDORES
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}


	// METODOS GETTERS / SETTERS
	public Color getColor() {	// Somente metodo GET pois a cor de uma peça nao pode ser modificada
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	
	// DEMAIS METODOS
	public void increaseMoveCount() {
		moveCount++;
	}

	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);	//converte um position para chess position
	}
	
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
