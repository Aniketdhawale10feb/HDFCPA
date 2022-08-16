import Base_utility.Comman;
import Page_Utility.LandingPage;
import Page_Utility.OfferPage;
import Page_Utility.SourcingPage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static Base_utility.Comman.driver;

public class SmokeTest
{
    LandingPage lp= new LandingPage(driver);
    SourcingPage sp= new SourcingPage(driver);
    OfferPage op = new OfferPage(driver);

    @BeforeTest()
    public void BforeTest()
    {
        lp.InvokeBrowser("chrome");
        lp.ImpliWait( 10L);
        lp.MaximiseBrowser();

        PageFactory.initElements(driver,lp);
        PageFactory.initElements(driver,sp);
        PageFactory.initElements(driver,op);
    }

    @AfterTest
    public void AfterTest()
    {lp.Quit();}

    @Test(priority = 0)
    public void loginSu(Method method) throws IOException
    {
        lp.LoadURL("https://ssgqa.serviceurl.in/eSign/");

        Assert.assertEquals("E-Sign",driver.getTitle());

        lp.EnterMobileNum("9948064929");
        lp.EnterPanNum("AAAPM3484F");
        lp.ClickCheckBox();
        lp.ClickReadMore();
        lp.ClickReadLess();
        lp.ClickReceiveOtp();
        lp.EnterOtp("123456");
        lp.ClickSubmitOtp();

        lp.expwait(op.OfferPageHeader, 30);
        FileUtils.deleteQuietly(new File("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots"));
        FileUtils.deleteQuietly(new File("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/failedScreens/"));
        FileUtils.deleteQuietly(new File("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/SuccessScreens/"));

        lp.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/",method.getName());
    }

    @Test(priority = 1)
    public void OfferPageTest(Method method) throws IOException
    {
        Assert.assertTrue(op.OfferPageHeader.isDisplayed());
        Assert.assertTrue(op.OfferAmount.isDisplayed());
        Assert.assertTrue(op.ROI.isDisplayed());
        op.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/","AllOfferPageelements");
        Assert.assertTrue(op.Tenure.isDisplayed());
        op.ClickOnAccept();
    }


}
