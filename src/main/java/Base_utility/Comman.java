package Base_utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
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
    public void TakeScreenShot(String Location,String Name) throws IOException {
        TakesScreenshot TC = (TakesScreenshot) driver;
        File Source = TC.getScreenshotAs(OutputType.FILE);
        File Target = new File(Location + Name+".png");
        FileUtils.copyFile(Source, Target);
    }

    //Method to wait explicitely until required element id visible
    public void ClickOn(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(Element));
        Element.click(); }

    //This function is used to enter the value in specified webelement
    public void EnterValue(WebElement Element, String Value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(Element));
        Element.sendKeys(Value);
    }

    //This function is used to load the URL using navigate command
    public void LoadURL(String Url)
    {
        driver.navigate().to(Url);
    }

    //This function is used to set the implicite wait
    public void ImpliWait(Long Time)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
    }

    //This function is used to maximize the browser
    public void MaximiseBrowser() {
        driver.manage().window().maximize();
    }

    //This function is used to set the explicite wait  untill element visibility for  specified time
    public  void expwait(WebElement Element, long Time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    //This function is used to quit the browser with 5 sec wait
    public void Quit()
    {try {Thread.sleep(5000);} catch(Exception e) {e.printStackTrace();}
        driver.quit();}

    // this function is used to hover mounse on a webelement
    public void HoverMouseOn(WebElement Element)
    {
        Actions action= new Actions(driver);
        action.moveToElement(Element);
    }

    // This function is used to right-click on a web element
    public void RightClickOn(WebElement Element)
    {
        Actions action= new Actions(driver);
        action.contextClick(Element);
    }


    // This function is used to scroll upto certain webElement
    public void ScrollTo(WebElement Element)
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("argument[0].srollIntoView(true), Element");
    }




}