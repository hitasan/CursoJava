package secao18.model.services;

import java.util.Calendar;
import java.util.Date;

import secao18.model.entities.Contract;
import secao18.model.entities.Installment;

// Classe de serviço para processamento do contrato 
public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); // Calculando o juros sobre o valor base da parcela
            double fullQuota =  updatedQuota + onlinePaymentService.paymentFee(updatedQuota);// Calculando a taxa de pagamento	sobre o valor base da parcela com o juros

            Date date = addMonths(contract.getDate(), i);	// Fixando qual a data da parcela

            contract.addInstallment(new Installment(date, fullQuota));	// Adicionado os dados da parcela
        }
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);

		return cal.getTime();
	}

}
