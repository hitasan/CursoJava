package secao16.boardgame;

public abstract class Piece {

	// ATRIBUTOS DA CLASSE
	protected Position position;	// Classe posi��o
	private Board board;			// Classe board
	
	
	// MOTODOS CONTRUTORES
	public Piece(Board board) {
		this.board = board;
		position = null;			// N�o tem necessidade de especificar que essa posi��o iniciar� nula pois o java j� faz isso na declara��o. S� para ficar didatico e melhor leitura.
	}


	// METODOS GETTERS / SETTERS
	protected Board getBoard() {	/// somente classe dentro do mesmo pacote e subclasse que vao poder acessar o tableiro de uma pe�a. Tabuleiro nao deve ser acessivel pela camada acima ChaessMatch
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
