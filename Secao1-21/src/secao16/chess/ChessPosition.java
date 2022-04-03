package secao16.chess;

import secao16.boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;

	// METODOS CONSTRUTORES
	public ChessPosition() {
	}

	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 ate h8.");
		}
		this.column = column;
		this.row = row;
	}


	// METODOS GETTERS / SETTERS
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}


	// DEMAIS METODOS
	protected Position toPositon() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;	// "" forma o compilador entender que é uma concatenação de strings
	}
	
}
