package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeMainPage {
    WebDriver driver;

    public OrangeMainPage(){
        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

//   @FindBy(id="menu_admin_vievAdminModule")
//    public Webelement adminButton;
}
