package org.acme;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

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
}
