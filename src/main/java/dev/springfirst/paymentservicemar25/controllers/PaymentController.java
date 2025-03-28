package dev.springfirst.paymentservicemar25.controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.springfirst.paymentservicemar25.dtos.GeneratePaymentRequestDTO;
import dev.springfirst.paymentservicemar25.services.PaymentService;
import dev.springfirst.paymentservicemar25.services.RazorPayGateway;
import dev.springfirst.paymentservicemar25.services.StripeGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    //dtos and models look similar to each other ut they are independent of each other
    //models are entities which we store in our dbs
    //dtos are objects which we might send or receive from my system

    private RazorPayGateway razorPayGateway;
    private StripeGateway stripeGateway;
    private int counter=0;

    public PaymentController(RazorPayGateway razorPayGateway, StripeGateway stripeGateway) {
        this.razorPayGateway = razorPayGateway;
        this.stripeGateway = stripeGateway;
    }
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentRequestDTO generatePaymentRequestDTO) throws RazorpayException, StripeException {
        //generate paymentlink and send the order id from the request

            return stripeGateway.generatePaymentLink(generatePaymentRequestDTO.getOrderId());
    }

}
