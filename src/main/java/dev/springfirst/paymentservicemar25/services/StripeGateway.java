package dev.springfirst.paymentservicemar25.services;

import org.springframework.stereotype.Service;

@Service("Stripe")
public class StripeGateway implements PaymentService{

    @Override
    public String generatePaymentLink(Long orderId) {
        return null;
    }
}
