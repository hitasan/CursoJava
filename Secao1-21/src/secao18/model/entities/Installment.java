package secao18.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

// CLASSE RESPONSAVEL PELAS PARCELAS DO CONTRATO
public class Installment {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dueDate;	// Data de vencimento
	private Double amount;	// valor

	// METODOS CONSTRUTORES
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	// METODOS GETTERS / SETTERS
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	// DEMAIS METODOS
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
 	}

}
