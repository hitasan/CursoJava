package secao18.model.services;

public interface OnlinePaymentService {

	//Metodos que serão obrigados a serem implementados pela classe responsavel.
	double paymentFee(double amount);
	double interest(double amount, int months);

}
