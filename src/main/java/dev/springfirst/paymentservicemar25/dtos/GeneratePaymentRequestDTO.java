package dev.springfirst.paymentservicemar25.dtos;
//dtos are objects which we might send or receive from my system


public class GeneratePaymentRequestDTO {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
