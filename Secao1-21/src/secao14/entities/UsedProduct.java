package secao14.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	// Atributos da classe
	private Date manufactureDate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	// Metodos Construtores
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}


	// Metodos Getters / Setters
	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	
	// Metodos de processamento
	@Override
	public String priceTag() {
		return getName() 
			   + " (used) $ " + String.format("%.2f", getPrice())
			   + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}

}
