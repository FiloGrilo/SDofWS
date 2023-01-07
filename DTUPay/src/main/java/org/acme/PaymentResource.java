package org.acme;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/payments")
public class PaymentResource {
    private PaymentService pService = new PaymentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getPaymentJson() {
        return pService.getPaymentList();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Payment> getPaymentXml() {
        return pService.getPaymentList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean postPaymentJSON(Payment p) {
        return pService.addPayment(p);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean postPaymentXML(Payment p) {
        return pService.addPayment(p);
    }

}

