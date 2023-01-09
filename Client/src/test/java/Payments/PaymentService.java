package Payments;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import org.acme.*;

import java.math.BigDecimal;
import java.util.*;

public class PaymentService {

    WebTarget baseUrl;
    public PaymentService() {
        Client client = ClientBuilder.newClient();
        baseUrl = client.target("http://localhost:8080/");
    }

    public List<Payment> getPaymentListJson() {
        return getPaymentList(MediaType.APPLICATION_JSON);
    }

    public void addPaymentJson(Payment payment) {
         addPaymentList(payment,MediaType.APPLICATION_JSON);
    }

    public Response registerUserJson(CreateUser data) {
        return registerUser(data,MediaType.APPLICATION_JSON);
    }
    public BigDecimal getBalanceJson(String id) {
        return getBalance(id,MediaType.APPLICATION_JSON);
    }
    public void transferMoneyJson(Transfer data) {
        transfer(data,MediaType.APPLICATION_JSON);
    }
    public void deleteAccountJson(String id) {
        deleteAccount(id,MediaType.APPLICATION_JSON);
    }

    private List<Payment> getPaymentList(String mediaType) {
        return (List<Payment>) baseUrl.path("payment")
                .request()
                .accept(mediaType)
                .get();
    }

    private Response addPaymentList(Payment payment,String mediaType) {
        return baseUrl.path("payments")
                .request()
                .put(Entity.entity(payment, mediaType));
    }
    private Response registerUser(CreateUser data,String mediaType){
        return  baseUrl.path("payments/RegisterUser")
                .request()
                .put(Entity.entity(data, mediaType));
    }
    private BigDecimal getBalance(String id,String mediaType) {
        return baseUrl.path("payments/getBalance/{id}")
                .request()
                .accept(mediaType)
                .get(BigDecimal.class);
    }
    private Response transfer(Transfer data,String mediaType){
        return  baseUrl.path("payments/transfer")
                .request()
                .put(Entity.entity(data, mediaType));
    }
    private Response deleteAccount(String id,String mediaType){
        return  baseUrl.path("payments/deleteAccount")
                .request()
                .put(Entity.entity(id, mediaType));
    }

}
