package dev.springfirst.paymentservicemar25.services;

import org.springframework.stereotype.Service;

@Service("Razorpay")
public class RazorPayGateway implements PaymentService{

    /*
    Will first make a call to order service to verify the order id and get the order details
    Rest template can be used to interact with order service. this will be done in future
    Assuming that order id is valid and assuming some amount
     */
    @Override
    public String generatePaymentLink(Long orderId) {
        return null;
    }
}
