
package model.service;

import java.util.Calendar;
import java.util.Date;
import model.entities.Contract;
import model.entities.Installment;

/**
 *
 * @author Roberto
 */
public class ContractService {
        
    private OnlinePaymentService onlinePaymentService;
    
    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }
    
    public void processContract(Contract contract,Integer months){
        
        for (int i = 1;i <= months ; i++){
            double aux = onlinePaymentService.interest(contract.getTotalValue()/months, i);
            aux = onlinePaymentService.paymentFee(aux);
            Calendar cal = Calendar.getInstance();
            Date date = contract.getDate();
            cal.setTime(date);
            cal.add(Calendar.MONTH, i);
            date = cal.getTime();
            contract.addInstallment(new Installment(date,aux));
        }
    }
}
