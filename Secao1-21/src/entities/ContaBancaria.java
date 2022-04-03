package entities;

public class ContaBancaria {

	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private int nrCta;
	private String nomeCta;
	private Double saldoCta;


	// ----------------------------------------------------------------------------------------
	// METODOS CONSTRUTOR
	// ----------------------------------------------------------------------------------------
	public ContaBancaria() {
	}
	
	public ContaBancaria(int nrCta, String nomeCta) {
		this.nrCta = nrCta;
		this.nomeCta = nomeCta;
		this.saldoCta = 0.0;
	}

	public ContaBancaria(int nrCta, String nomeCta, Double saldoCta) {
		this.nrCta = nrCta;
		this.nomeCta = nomeCta;
		this.saldoCta = saldoCta;
	}

	// ----------------------------------------------------------------------------------------
	// METODOS GET / SET
	// ----------------------------------------------------------------------------------------
	public int getNrConta() {
		return nrCta;
	}

	public String getNome() {
		return nomeCta;
	}

	public void setNome(String nomeCta) {
		this.nomeCta = nomeCta;
	}

	public Double getSaldo() {
		return saldoCta;
	}

	
	// ----------------------------------------------------------------------------------------
	// OUTROS METODOS
	// ----------------------------------------------------------------------------------------
	public void depositoConta(Double valor) {
		saldoCta += valor;
	}

	public void saqueConta(Double valor) {
		saldoCta -= valor + 5.0;
	}

	public String toString() {
		return "Account "
			   + getNrConta()
			   + ", Holder: "
			   + getNome()
			   + ", Balance: $ "
			   + String.format("%.2f", getSaldo());
	}
	
	
	
}
