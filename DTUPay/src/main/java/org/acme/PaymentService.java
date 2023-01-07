package org.acme;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

import dtu.ws.fastmoney.Account;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;

public class PaymentService {

    BankService service = (new BankServiceService()).getBankServicePort();
    private List<Payment> paymentList = new ArrayList<>();

    private Payment payment= new Payment("cid1","mid1",100);

    public PaymentService() {
        paymentList.add(payment);
    }
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public boolean addPayment(Payment p) {
        return paymentList.add(p);
    }

    public Response registerUser(CreateUser data) {
        try {
            var id = service.createAccountWithBalance(data.user, data.balance);
            return Response.ok(id).build();
        } catch (BankServiceException_Exception e) {
            System.err.println("Got error: " + e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getCause()).build();
        }
    }

}
