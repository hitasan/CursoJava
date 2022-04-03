package secao16.chess.pieces;

import secao16.boardgame.Board;
import secao16.boardgame.Position;
import secao16.chess.ChessMatch;
import secao16.chess.ChessPiece;
import secao16.chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	// CONSTRUTORES
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}


	// DEMAIS METODOS
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			// Regra para permitir o peao mover uma casa para cima
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// Regra para permitir o peao mover duas casas para cima
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position( position.getRow() - 1, position.getColumn() );
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&  getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Regra para permitir o peao mover uma casa na diagonal se tiver uma peça adversaria
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if ( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if ( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Tratamento para en passant
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.enPassantVulnarable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.enPassantVulnarable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			// Regra para permitir o peao mover uma casa para cima
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// Regra para permitir o peao mover duas casas para cima
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position( position.getRow() + 1, position.getColumn() );
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&  getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Regra para permitir o peao mover uma casa na diagonal se tiver uma peça adversaria
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if ( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if ( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Tratamento para en passant
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.enPassantVulnarable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.enPassantVulnarable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
