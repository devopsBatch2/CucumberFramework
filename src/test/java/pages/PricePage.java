package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PricePage {

    WebDriver driver;

    public PricePage() {
        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);


    }
}