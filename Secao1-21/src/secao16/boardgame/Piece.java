package secao16.boardgame;

public abstract class Piece {

	// ATRIBUTOS DA CLASSE
	protected Position position;	// Classe posição
	private Board board;			// Classe board
	
	
	// MOTODOS CONTRUTORES
	public Piece(Board board) {
		this.board = board;
		position = null;			// Não tem necessidade de especificar que essa posição iniciará nula pois o java já faz isso na declaração. Só para ficar didatico e melhor leitura.
	}


	// METODOS GETTERS / SETTERS
	protected Board getBoard() {	/// somente classe dentro do mesmo pacote e subclasse que vao poder acessar o tableiro de uma peça. Tabuleiro nao deve ser acessivel pela camada acima ChaessMatch
		return board;
	}
	
	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
}
