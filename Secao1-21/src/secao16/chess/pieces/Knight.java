package secao16.chess.pieces;

import secao16.boardgame.Board;
import secao16.boardgame.Position;
import secao16.chess.ChessPiece;
import secao16.chess.Color;

public class Knight extends ChessPiece {

	// METODOS CONTRUTORES
	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	
	// DEMAIS METODOS
	private boolean canMove(Position position) {				// Metodo que indica se o rei poder� ser movido para a posi��o recebida no parametro
		ChessPiece p = (ChessPiece)getBoard().piece(position);	// pego a pe�a que estiver na posi��o
		return p == null || p.getColor() != getColor();			// retorno se pode mover para uma casa vazia ou se tem uma pe�a adversaria
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() - 2, position.getColumn() + 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() - 1, position.getColumn() + 2 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() + 1 , position.getColumn() + 2 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() + 2, position.getColumn() + 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() + 2 , position.getColumn() - 1 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() + 1 , position.getColumn() - 2 );
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
	
	@Override
	public String toString() {
		return "N";
	}
	

}
