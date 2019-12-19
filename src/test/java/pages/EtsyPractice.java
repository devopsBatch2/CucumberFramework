package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyPractice {

    WebDriver driver;
   public  EtsyPractice(){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//img[@class='width-full wt-height-full display-block position-absolute '])[1]")
    public WebElement wallet;

    @FindBy(xpath="//input[@id='global-enhancements-search-query']")
    public WebElement searchbox;

    @FindBy(xpath="(//img[@class='width-full wt-height-full display-block position-absolute '])[1]")
    public WebElement wallet1;

}
