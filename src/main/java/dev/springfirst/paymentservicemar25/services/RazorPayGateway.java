package dev.springfirst.paymentservicemar25.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorPayGateway implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorPayGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;

    }
    /*
    Will first make a call to order service to verify the order id and get the order details
    Rest template can be used to interact with order service. this will be done in future
    Assuming that order id is valid and assuming some amount
     */
    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {


        //code for calling the razorpay to get the link
        /*
        {
            amount:
            currency:
            partial_amount:
            expireBy:
            ..
            customer:{
                name:
                email:
                phone:
            }

        }
         */

        JSONObject paymentLinkRequest = new JSONObject();//request body/sending the payload to razorpay
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        //paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()+10*60*1000);//epoch(current time+10mins)
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Test payment for session in march2025");

        JSONObject customer = new JSONObject();
        customer.put("name","Akshitha");
        customer.put("contact","+91 8761228091");
        customer.put("email","akshithaganji19@gmail.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);

       // JSONObject notes = new JSONObject();
        //notes.put("policy_name","Jeevan Bima");
        //paymentLinkRequest.put("notes",notes);

        paymentLinkRequest.put("callback_url","https://www.google.co.in/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
