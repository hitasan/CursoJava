package secao16.boardgame;

public class Board {

	// ATRIBUTOS DA CLASSE
	private int rows;
	private int columns;
	private Piece[][] pieces;


	// METODOS CONSTRUTORES
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating  board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	
	// METODOS GETTERS / SETTERS
	public int getRows() {
		return rows;
	}
	//public void setRows(int rows) {			// Retirado para nao permitir alterar a quantidade de linhas
		//this.rows = rows;
	//}
	public int getColumns() {
		return columns;
	}
	//public void setColumns(int columns) {		// Retirado para nao permitir alterar a quantidade de colunas
		//this.columns = columns;
	//}
	
	
	// METODOS DE PROCESSAMENTO
	public Piece piece(int row, int column) {	// metodo para linhas e colunas
		if (positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {		// metodo de sobrecarga para posição
		if (positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position" + position);
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		if (piece(position) == null) {	// Não existe peça nessa posição
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private Boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public Boolean thereIsAPiece(Position position) {
		if (positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
}
