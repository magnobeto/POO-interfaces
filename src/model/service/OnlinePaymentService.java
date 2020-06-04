
package model.service;

/**
 *
 * @author Roberto
 */
public interface OnlinePaymentService {

    public Double paymentFee(Double amount);
    public Double interest(Double amount,Integer months); 
}
