package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AuthenticationPage;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class AuthenticationStepDefs {

    AuthenticationPage page = new AuthenticationPage();

    @Given("^Navigate to web page$")
    public void navigate_to_web_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl2"));
        Thread.sleep(3000);
    }

    @Then("^Navigate to sign in button$")
    public void navigate_to_sign_in_button() throws Throwable {
        page.signInBtn.click();
        Thread.sleep(3000);

    }

    @Then("^User logs in with valid email \"([^\"]*)\" and creates an account$")
    public void user_logs_in_with_valid_email_and_creates_an_account(String emailName) throws Throwable {
        page.emailInput.sendKeys(emailName);
        page.clickAccBtn.click();
        Thread.sleep(3000);
    }

    @Then("^User enters his Personal Information$")
    public void user_enters_his_Personal_Information(DataTable dataTable) throws Throwable {

        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);
        page.genderBtn.click();
        Thread.sleep(2000);
        page.firstName.sendKeys(listOfMaps.get(0).get("First name").toString());
        Thread.sleep(2000);
        page.lastName.sendKeys(listOfMaps.get(0).get("Last name").toString());
        Thread.sleep(2000);

        page.emailTitle.sendKeys(listOfMaps.get(0).get("Email").toString());
        Thread.sleep(2000);

        page.password.sendKeys(listOfMaps.get(0).get("Password").toString());
        Thread.sleep(2000);
        page.firstNameAdd.sendKeys(listOfMaps.get(0).get("First name").toString());
        Thread.sleep(2000);

        page.lastNameAdd.sendKeys(listOfMaps.get(0).get("Last name").toString());
        //
        // Thread.sleep(2000);
        page.compnayInput.sendKeys(listOfMaps.get(0).get("Company").toString());
        Thread.sleep(2000);

        page.addressInput1.sendKeys(listOfMaps.get(0).get("Address").toString());
        Thread.sleep(2000);

        page.city.sendKeys(listOfMaps.get(0).get("City").toString());
        Thread.sleep(2000);

        Select select1 = new Select(page.selectState);
        select1.selectByVisibleText(listOfMaps.get(0).get("State").toString());
        Thread.sleep(2000);

        // page.selectState.sendKeys(listOfMaps.get(0).get("State").toString());
        // Thread.sleep(2000);
        page.zipCode.sendKeys(listOfMaps.get(0).get("Zip/Postal Code").toString());
        Thread.sleep(2000);

        Select select2 = new Select(page.selectCountry);
        page.selectCountry.sendKeys(listOfMaps.get(0).get("Country").toString());
        Thread.sleep(2000);

        page.mobilePhone.sendKeys(listOfMaps.get(0).get("Mobile phone").toString());
        Thread.sleep(2000);
        page.additionalInfo.sendKeys(listOfMaps.get(0).get("Assign an address alias for future reference.").toString());
        Thread.sleep(2000);
        page.registerBtn.click();
        Thread.sleep(4000);
    }
    @Then("^Verify if the account is created by signing in$")
    public void verify_if_the_account_is_created_by_signing_in() throws Throwable {
        String actualTitle = Driver.driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("My title after signing in is : "+actualTitle);
    }
    @Then("^User signs in with valid credentials email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_signs_in_with_valid_credentials_email_and_password(String emailSignin, String passwdSignIn) throws Throwable {
        page.signIn.sendKeys(emailSignin);
        Thread.sleep(2000);
        page.passwd.sendKeys(passwdSignIn);
        Thread.sleep(2000);
        page.submitBtn.click();
        Thread.sleep(2000);
    }
    @Then("^User signs in with invalid credentials email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_signs_in_with_invalid_credentials_email_and_password(String emailWrong, String passwdWrong) throws Throwable {
        page.signIn.sendKeys(emailWrong);
        Thread.sleep(2000);
        page.passwd.sendKeys(passwdWrong);
        Thread.sleep(2000);
        page.submitBtn.click();
        Thread.sleep(2000);
        String actualError=page.errMessage.getText();
        String expectederror="There is 1 error";
        Assert.assertEquals(expectederror,actualError);
    }
}






