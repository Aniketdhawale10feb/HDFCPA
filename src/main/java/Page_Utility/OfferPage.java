package Page_Utility;

import Base_utility.Comman;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPage extends Comman
{
    public OfferPage (WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    Comman comman = new Comman();

    @FindBy(xpath = "//span/mat-panel-title")
    public WebElement OfferPageHeader;

    @FindBy(xpath ="//div/h6[contains(text(),'Rs.')]")
    public WebElement OfferAmount;

    @FindBy(xpath = "//div/h6[contains(text(),'%')]")
    public WebElement ROI;

    @FindBy(xpath = "//div/h6[contains(text(),'Month')]")
    public WebElement Tenure;

    @FindBy(xpath ="//span[contains(text(),'ACCEPT')]")
    public WebElement AcceptButton;

    @FindBy(xpath ="//span[contains(text(),'DECLINE')]")
    public WebElement DeclineButton;

    public void ClickOnAccept()
    {
        comman.ClickOn(AcceptButton);
    }
    public void ClickOnDecline()
    {
        comman.ClickOn(DeclineButton);
    }

}
