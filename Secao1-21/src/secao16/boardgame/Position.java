package secao16.boardgame;

public class Position {

	// ATRIBUTOS DA CLASSE
	private int row;
	private int column;
	

	// METODOS CONSTRUTORES
	public Position() {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}


	// METODOS GETTERS / SETTERS
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}

	
	// METODOS DE PROCESSAMENTO E IMPRESSÃO
	@Override
	public String toString() {
		return row + "," + column;
	}
}
