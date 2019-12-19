package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrdersPage {

    WebDriver driver;
    public OrdersPage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productName;

    @FindBy (id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;//id

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy (xpath="//input[@value='Visa']")
    public WebElement card;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNr;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy (id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy (xpath = "//a[@href='Default.aspx']")
    public WebElement ordersViewButton;

}
