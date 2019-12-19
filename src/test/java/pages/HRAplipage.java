package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HRAplipage {

    WebDriver driver;

    public HRAplipage() {
        driver = Driver.driver;
        this.driver=Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);

    }
    @FindBy (xpath = "//table[@id='europe-employees']//tbody[2]//tr")
     public List<WebElement> listOfEmployees;


}