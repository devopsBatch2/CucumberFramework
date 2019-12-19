package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AuthenticationPage {

    WebDriver driver;
   public AuthenticationPage (){
        this.driver= Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInBtn;

    @FindBy(id = "email_create")
    public WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    public WebElement clickAccBtn;

    //Title registration
    @FindBy(id = "id_gender2")
    public WebElement genderBtn;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement emailTitle;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement selectDays;

    @FindBy(id = "months")
    public WebElement selectMonth;

    @FindBy(id = "years")
    public WebElement selectYears;

    @FindBy(id = "uniform-optin")
    public WebElement specialOffers;

    //Address Line registration
    @FindBy(id = "firstname")
    public WebElement firstNameAdd;

    @FindBy(id = "lastname")
    public WebElement lastNameAdd;

    @FindBy(id = "company")
    public WebElement compnayInput;

    @FindBy(id = "address1")
    public WebElement addressInput1;

    @FindBy(id = "address2")
    public WebElement addressInput2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement selectState;

    @FindBy(id = "postcode")
    public WebElement zipCode;

    @FindBy(id = "id_country")
    public WebElement selectCountry;

    @FindBy(id = "other")
    public WebElement additionalInfo;

    @FindBy(id = "phone")
    public WebElement homePhone;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy(id = "alias")
    public WebElement futureReferences;

    @FindBy(id = "submitAccount")
    public WebElement registerBtn;


//    @FindBy (xpath = "//input[@id='email']")
// public WebElement emailAddress;
//
//   @FindBy (xpath = "//input[@id='passwd']")
//  public WebElement password1;

  @FindBy(id ="email")
  public WebElement signIn;

  @FindBy(id = "passwd")
  public WebElement passwd;

  @FindBy(id = "SubmitLogin")
  public WebElement  submitBtn;

  @FindBy(xpath = "//p[text()='There is 1 error']")
  public WebElement errMessage;

}
