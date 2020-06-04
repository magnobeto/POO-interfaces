
package model.service;

/**
 *
 * @author Roberto
 */
public class PayPalService implements OnlinePaymentService {
    
    public PayPalService(){
    }

    @Override
    public Double paymentFee(Double amount) {
        return amount+amount*0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount + amount * 0.01 * months;
    }
}
