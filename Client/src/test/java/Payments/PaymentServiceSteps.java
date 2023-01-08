package Payments;

import dtu.ws.fastmoney.*;
import org.acme.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.acme.CreateUser;

import java.math.BigDecimal;

public class PaymentServiceSteps {
    PaymentService service= new PaymentService();
    User user= new User();
    CreateUser createUser= new CreateUser();
    @Given("a customer with a bank account with balance {int}")
    public void a_customer_with_a_bank_account_with_balance(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        user.setCprNumber("3333333");
        user.setFirstName("Tiago");
        user.setLastName("Silverio");
        createUser.user=user;
        createUser.balance= new BigDecimal(int1);
        service.registerUserJson(createUser);
    }

    @Given("that the customer is registered with DTU Pay")
    public void that_the_customer_is_registered_with_dtu_pay() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("a merchant with a bank account with balance {int}")
    public void a_merchant_with_a_bank_account_with_balance(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("that the merchant is registered with DTU Pay")
    public void that_the_merchant_is_registered_with_dtu_pay() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the merchant initiates a payment for {int} kr by the customer")
    public void the_merchant_initiates_a_payment_for_kr_by_the_customer(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the payment is successful")
    public void the_payment_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the balance of the customer at the bank is {int} kr")
    public void the_balance_of_the_customer_at_the_bank_is_kr(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the balance of the merchant at the bank is {int} kr")
    public void the_balance_of_the_merchant_at_the_bank_is_kr(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
