package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EtsyPractice;
import utilities.Configuration;
import utilities.Driver;

public class EtsyPractice1 {

    EtsyPractice ep=new EtsyPractice();

    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigate_to(String arg1) throws Throwable {
        Driver.driver.get(Configuration.getProperties("etsyUrl"));

        Thread.sleep(3000);

        throw new PendingException();
    }

    @When("^Search \"([^\"]*)\"$")
    public void search(String wallet) throws Throwable {

        ep.searchbox.click();
        ep.searchbox.sendKeys(wallet + Keys.ENTER);
        throw new PendingException();
    }

    @Then("^Verify the result$")
    public void verify_the_result() throws Throwable {
       String wallet3=ep.wallet1.getText();
       Assert.assertTrue((wallet3.contains("Wallet")));

        throw new PendingException();
    }


}
