package Page_Utility;

import Base_utility.Comman;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;

public class LandingPage extends Comman
{
    Comman comman= new Comman();
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='custMobNo']")
    public WebElement MobileNumber;

    @FindBy(xpath = "//input[@name='panNumber']")
    public WebElement PanNumber;

    @FindBy(xpath = "//input[@id='acceptTerms']")
    public WebElement CheckBox;

    @FindBy(xpath = "//span/a[@href='https://www.hdfcbank.com/personal/useful-links/privacy']")
    public WebElement PrivicyPolicy;

    @FindBy(xpath = "//span/a[contains(text(),'Consent Terms')]")
    public WebElement ConscentTerms;

    @FindBy(xpath = "//a[contains(text(),'Read less...')]")
    public WebElement ReadLess;

    @FindBy(xpath = "//a[contains(text(),'Read more..')]")
    public WebElement ReadMore;

    @FindBy(xpath = "//span[contains(text(),'Receive OTP')]")
    public WebElement ReceiveOtp;

    @FindBy(xpath = "//input[@name='otp']")
    public WebElement EnterOtp;

    @FindBy(xpath = "//span[contains(text(),'Submit OTP')]")
    public WebElement SubmitOtp;


    public void EnterMobileNum(String value)
    {
        comman.EnterValue(MobileNumber,value);
    }

    public void EnterPanNum(String value )
    {
        comman.EnterValue(PanNumber,value);
    }

    public void ClickCheckBox()
    {
        comman.ClickOn(CheckBox);
    }

    public void ClickReadMore()
    {
        comman.ClickOn(ReadMore);
    }

    public void ClickReadLess()
    {
        comman.ClickOn(ReadLess);
    }

    public void ClickReceiveOtp()
    {
        comman.ClickOn(ReceiveOtp);
    }

    public void EnterOtp(String value)
    {
        comman.EnterValue(EnterOtp,value);
    }

    public void ClickSubmitOtp()
    {
        comman.ClickOn(SubmitOtp);
    }

}
