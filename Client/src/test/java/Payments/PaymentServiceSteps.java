package Payments;

import fastmoney.*;
import io.cucumber.java.After;
import jakarta.validation.constraints.AssertTrue;
import org.acme.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.acme.CreateUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

public class PaymentServiceSteps {
    PaymentService service= new PaymentService();
    User BankCostumer= new User();
    User BankMerchant = new User();
    CreateUser createCostumer= new CreateUser();
    CreateUser createMerchant = new CreateUser();
    Payment payment= new Payment();
    Transfer transfer= new Transfer();

    String merchantId = new String();
    String costumerId = new String();
    @Given("a customer with a bank account with balance {int}")
    public void a_customer_with_a_bank_account_with_balance(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        BankCostumer.setCprNumber("3333333");
        BankCostumer.setFirstName("Tiago");
        BankCostumer.setLastName("Silverio");
        createCostumer.user=BankCostumer;
        createCostumer.balance= new BigDecimal(int1);
    }

    @Given("that the customer is registered with DTU Pay")
    public void that_the_customer_is_registered_with_dtu_pay() {
        // Write code here that turns the phrase above into concrete actions
        costumerId= String.valueOf(service.registerUserJson(createCostumer));
    }

    @Given("a merchant with a bank account with balance {int}")
    public void a_merchant_with_a_bank_account_with_balance(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        BankMerchant.setCprNumber("3333333");
        BankMerchant.setFirstName("Tiago");
        BankMerchant.setLastName("Silverio");
        createMerchant.user=BankMerchant;
        createMerchant.balance= new BigDecimal(int1);
    }

    @Given("that the merchant is registered with DTU Pay")
    public void that_the_merchant_is_registered_with_dtu_pay() {
        // Write code here that turns the phrase above into concrete actions
        merchantId= String.valueOf(service.registerUserJson(createMerchant));

    }

    @When("the merchant initiates a payment for {int} kr by the customer")
    public void the_merchant_initiates_a_payment_for_kr_by_the_customer(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        transfer.amount=new BigDecimal(int1);
        transfer.from=BankCostumer.getFirstName();
        transfer.to=BankMerchant.getFirstName();
        service.transferMoneyJson(transfer);
    }

    @Then("the payment is successful")
    public void the_payment_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        payment.setMid(transfer.to);
        payment.setCid(transfer.from);
    }

    @Then("the balance of the customer at the bank is {int} kr")
    public void the_balance_of_the_customer_at_the_bank_is_kr(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(service.getBalanceJson(costumerId), new BigDecimal(900));
    }

    @Then("the balance of the merchant at the bank is {int} kr")
    public void the_balance_of_the_merchant_at_the_bank_is_kr(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(service.getBalanceJson(merchantId), new BigDecimal(1100));
    }
    @After
    public void afterStep() {
        service.deleteAccountJson(merchantId);
        service.deleteAccountJson(costumerId);
    }

}
