package dev.springfirst.paymentservicemar25.services;

//Adapter design pattern
//It is a interface as it can have multiple variations/implementations
public interface PaymentService {

    public String generatePaymentLink(Long orderId);



}
