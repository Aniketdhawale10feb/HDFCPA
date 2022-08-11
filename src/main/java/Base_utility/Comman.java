package Base_utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;

public class Comman {
    public static WebDriver driver;
    // Method to invoke browser by name
    public void InvokeBrowser(String BrowserName)
    {
        if (BrowserName.equalsIgnoreCase("chrome") || BrowserName.equalsIgnoreCase("Google chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/lentraadmin/IdeaProjects/HDFCPA/BrowserDrivers/chromedriver");
            driver = new ChromeDriver();

        } else if (BrowserName.equalsIgnoreCase("mozila") || BrowserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/home/lentraadmin/IdeaProjects/HDFCPA/BrowserDrivers/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    //Method to take screenshot
    public void TakeScreenShot(String Location, String Name) throws IOException {
        TakesScreenshot TC = (TakesScreenshot) driver;
        File Source = TC.getScreenshotAs(OutputType.FILE);
        File Target = new File(Location + Name);
        FileUtils.copyDirectory(Source, Target);
    }

    //Method to wait explicitely until required element id visible
    public void ClickOn(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(Element));
        Element.click(); }

    public void EnterValue(WebElement Element, String Value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(Element));
        Element.sendKeys(Value);
    }
    public void LoadURL(String Url)
    {
        driver.navigate().to(Url);
    }

    public void ImpliWait(Long Time)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
    }

    public void MaximiseBrowser() {
        driver.manage().window().maximize();
    }

    public  void expwait(WebElement Element, long Time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }
    public void Quit()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }
}