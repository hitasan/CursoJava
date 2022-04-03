package secao18.model.services;

public class BrazilTaxService implements TaxService {

	public double tax(double amount) {	// double em minusculo pois estou assumindo que sempre virá um valor por parametro
		
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
 
	}
}
