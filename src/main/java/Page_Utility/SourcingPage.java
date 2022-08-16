package Page_Utility;

import Base_utility.Comman;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SourcingPage extends Comman
{
    Comman comman= new Comman();
    public SourcingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='mat-content']/mat-panel-title")
    public WebElement Header;

    @FindBy(xpath = "//input[@id='mat-input-0']")
    public WebElement MobileNo;

    @FindBy(xpath = "//input[@id='mat-input-1']")
    public WebElement PanNo;

    @FindBy(xpath = "//input[@id='mat-input-2']")
    public WebElement RequestedAmount;

    @FindBy(xpath = "//span[text()='Continue']")
    public WebElement Continue;

    @FindBy(xpath = "//div[@class='logout']/button[@type='button']")
    public WebElement Logout;


    public void EnterRequestedAmount(String value)
    {
        comman.EnterValue(RequestedAmount,value);
    }
    public void ClickOnContinue()
    {
        comman.ClickOn(Continue);
    }
    public void ClickOnLogout()
    {
        comman.ClickOn(Logout);
    }

}
