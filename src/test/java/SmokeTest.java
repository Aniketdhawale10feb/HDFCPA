import Page_Utility.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Base_utility.Comman.driver;

public class SmokeTest
{
    LandingPage lp= new LandingPage(driver);

    @BeforeTest()
    public void BforeTest()
    {
        lp.InvokeBrowser("chrome");
        lp.ImpliWait( 10L);
        lp.MaximiseBrowser();
    }

    @AfterTest
    public void AfterTest()
    {
        lp.Quit();
    }

    @Test
    public void login() throws IOException {
        PageFactory.initElements(driver,lp);
        lp.LoadURL("https://ssgqa.serviceurl.in/eSign/");
        lp.EnterMobileNum("8446676666");
        lp.EnterPanNum("CPYPR0545K");
        lp.ClickCheckBox();
        lp.ClickReadMore();
        lp.ClickReadLess();
        lp.ClickReceiveOtp();

        lp.EnterOtp("123456");

        lp.ClickSubmitOtp();
        lp.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/","Login");
    }




}
