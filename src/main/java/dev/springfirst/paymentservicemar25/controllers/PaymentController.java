package dev.springfirst.paymentservicemar25.controllers;

import dev.springfirst.paymentservicemar25.dtos.GeneratePaymentRequestDTO;
import dev.springfirst.paymentservicemar25.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    //dtos and models look similar to each other ut they are independent of each other
    //models are entities which we store in our dbs
    //dtos are objects which we might send or receive from my system

    private PaymentService paymentService;

    public PaymentController(@Qualifier("Razorpay") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentRequestDTO generatePaymentRequestDTO) {
        //generate paymentlink and send the order id from the request
        return paymentService.generatePaymentLink(generatePaymentRequestDTO.getOrderId());

    }

}
