package secao16.chess.pieces;

import secao16.boardgame.Board;
import secao16.boardgame.Position;
import secao16.chess.ChessPiece;
import secao16.chess.Color;

public class Queen extends ChessPiece {

	// METODOS CONTRUTORES
	public Queen(Board board, Color color) {
		super(board, color);
	}


	// DEMAIS METODOS
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0,0);
		
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// ACIMA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// ESQUERDA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// DIREITA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// BAIXO da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}
		
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// DIAGONAL SUPERIOR ESQUERDA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1, position.getColumn() -1 );
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// DIAGONAL SUPERIOR DIREITA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// DIAGONAL INFERIOR DIREITA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// DIAGONAL INFERIOR ESQUERDA da minha peça
		// -----------------------------------------------------------------------------------------------------------------------------------------------
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {	// enquanto a posição p existir e nao tiver uma peça
			mat[p.getRow()][p.getColumn()] = true;	// marcação a posição da matriz como true
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {	// se existe a posição e a mesma tiver uma peça adversaria
			mat[p.getRow()][p.getColumn()] = true;	// marcaçao a posição da matriz como true
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "Q";				// Imprime a letra Q que representa a Rainha
	}
}
