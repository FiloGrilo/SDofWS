package org.acme;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import dtu.ws.fastmoney.*;

public class PaymentService {

    BankService service = (new BankServiceService()).getBankServicePort();

    private List<Payment> paymentList = new ArrayList<>();

    private Payment payment= new Payment("cid1","mid1",new BigDecimal(100));

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
    public Response getBalance(@PathParam String id) {
        try {
            var user = service.getAccount(id);
            if (user == null) {
                return Response.status(Response.Status.PRECONDITION_FAILED).entity("User does not exist").build();
            }
            return Response.ok(user.getBalance()).build();
        } catch (BankServiceException_Exception e) {
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getCause()).build();
        }
    }
        public Response transferMoney(Transfer data) {
            try {
                service.transferMoneyFromTo(data.from, data.to, data.amount, data.description);
                return Response.ok().build();
            } catch (BankServiceException_Exception e) {
                return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getCause()).build();
            }
        }
    public Response deleteAccount(String id) {
        try {
            service.retireAccount(id);
            return Response.ok().build();
        } catch (BankServiceException_Exception e) {
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getCause()).build();
        }
    }

}
