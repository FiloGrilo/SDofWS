
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class PaymentSteps {
    public PaymentSteps() {
        @Given("a customer with a bank account with balance")
        public void ACustomerWithaBankAccountWithBalance( BigDecimal amount){
            
        }
        Given("^a customer with a bank account with balance (\\d+)$", (Integer arg0) -> {
        });
        And("^that the customer is registered with DTU Pay$", () -> {
        });
        Given("^a@ merchant with a bank account with balance (\\d+)$", (Integer arg0) -> {
        });
        And("^that the merchant is registered with DTU Pay$", () -> {
        });
        When("^the merchant initiates a payment for (\\d+) kr by the customer$", (Integer arg0) -> {
        });
        Then("^the payment is successful$", () -> {
        });
        And("^the balance of the customer at the bank is (\\d+) kr$", (Integer arg0) -> {
        });
        And("^the balance of the merchant at the bank is (\\d+) kr$", (Integer arg0) -> {
        });
    }
}
