package Page_Utility;

import Base_utility.Comman;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SourcingPage extends Comman
{
    public SourcingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='mat-content']/mat-panel-title")
    public WebElement Header;

}
