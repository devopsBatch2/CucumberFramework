package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EtsyNomePage;
import pages.EtsyResultPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

public class EtsySteps {
    EtsyNomePage page = new EtsyNomePage();
    EtsyResultPage page1 = new EtsyResultPage();


    @Given("^Navigate Etsy Homepage$")
    public void navigate_Etsy_Homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("etsyUrl"));
    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        page.searchBox.sendKeys(item + Keys.ENTER);

    }

    @Then("^Validate search message have word \"([^\"]*)\"$")
    public void validate_search_message_have_word(String item) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualSearchMessage = page1.searchMessage.getText();
        Assert.assertEquals(item, actualSearchMessage);
    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String department) throws Throwable {

        if (page.JeweleryA.getText().equalsIgnoreCase(department)) {
            page.JeweleryA.click();
        } else if (page.ClothesS.getText().equalsIgnoreCase(department)) {
            page.ClothesS.click();
        } else if (page.HomeL.getText().equalsIgnoreCase(department)) {
            page.HomeL.click();
        } else if (page.WeddingP.getText().equalsIgnoreCase(department)) {
            page.WeddingP.click();
        } else if (page.ToysE.getText().equalsIgnoreCase(department)) {
            page.ToysE.click();
        }
    }

    @Then("^User validate title \"([^\"]*)\"$")
    public void user_validate_title(String title) throws Throwable {
        String actualTitle = Driver.driver.getTitle();
        Assert.assertEquals(title, actualTitle);


    }

    @Then("^Click me Free shipping check box$")
    public void click_me_Free_shipping_check_box() throws Throwable {
        // BrowserUtils.hover(page1.freeShoppingCheckBox,Driver.driver);
        page1.freeShippingCheckBox.click();
        Thread.sleep(3000);

    }

    @Then("^Verify all results have \"([^\"]*)\" label$")
    public void verify_all_results_have_label(String label) throws Throwable {
        for (WebElement element: page1.freeShippingLabel) {
            Assert.assertEquals(label, element.getText().trim());

        }
    }
        @When("^User click on Over Price checkbox$")
        public void user_click_on_Over_Price_checkbox() throws Throwable {
            WebDriverWait wait=new WebDriverWait(Driver.driver,10);//cpesific elements-explicitly wait
            wait.until(ExpectedConditions.elementToBeClickable(page1.over1000Checkbox));
        page1.over1000Checkbox.click();

        }
        @Then("^User verifies all items prices are over that price$")
        public void user_verifies_all_items_prices_are_over_that_price() throws Throwable {
for (WebElement element: page1.resultPrices){
    String number=element.getText().replace(",","");
    System.out.println(number);

    if (!number.isEmpty()) {


        double price = Double.parseDouble(number);
        System.out.println(price);
        Assert.assertTrue(price >= 1000);


    }

}
        }





}














