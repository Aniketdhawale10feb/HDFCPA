import Page_Utility.LandingPage;
import Page_Utility.SourcingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static Base_utility.Comman.driver;

public class SmokeTest
{
    LandingPage lp= new LandingPage(driver);
    SourcingPage sp= new SourcingPage(driver);

    @BeforeTest()
    public void BforeTest()
    {
        lp.InvokeBrowser("chrome");
        lp.ImpliWait( 10L);
        lp.MaximiseBrowser();

        PageFactory.initElements(driver,lp);
        PageFactory.initElements(driver,sp);
    }

    @AfterTest
    public void AfterTest()
    {lp.Quit();}

    @Test
    public void loginSucces(Method method) throws IOException {

        lp.LoadURL("https://ssgqa.serviceurl.in/eSign/");

        Assert.assertEquals("E-Sign",driver.getTitle());

        lp.EnterMobileNum("8443344677");
        lp.EnterPanNum("CPUPR0995K");
        lp.ClickCheckBox();
        //lp.ClickReadMore();
        //lp.ClickReadLess();
        lp.ClickReceiveOtp();
        lp.EnterOtp("123456");
        lp.ClickSubmitOtp();
        sp.expwait(sp.Header, 30);
        lp.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/",method.getName());
    }

}
