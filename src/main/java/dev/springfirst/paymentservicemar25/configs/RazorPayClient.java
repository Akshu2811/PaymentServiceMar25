package dev.springfirst.paymentservicemar25.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayClient {

    //RAZORPAY_KEY_ID=rzp_test_4Lab7qbOzEiese;RAZORPAY_KEY_SECRET=Xu1jLAlcnnnlTBoAcypvV9VW
    @Value("${razorpay.key.id}")
    private String razorpayApiKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayApiKeySecret;

    @Bean
    public RazorpayClient createRazorPayClient() throws RazorpayException {
        return new RazorpayClient(razorpayApiKeyId,razorpayApiKeySecret);
    }
}
