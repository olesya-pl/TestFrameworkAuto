package testcases;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DriverInteractions extends BaseTest{
    @Test
    public void switchToTabTest (){
        driver.get(homePage.webSiteURL);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
       // driver.findElement(By.xpath(signInPage.inputEmail)).sendKeys(signInPage.emailValue);
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabHandler.size());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        tabHandler = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabHandler.size());
        driver.switchTo().window(tabHandler.get(4));
        driver.navigate().to("http://amazon.com");
    }


       @Test
  public void scrollTest() throws InterruptedException{
           driver.get(homePage.webSiteURL);
           JavascriptExecutor Js = (JavascriptExecutor) driver;
           Js.executeScript("window.scrollBy(0, 3000)", "");
           Thread.sleep(1000);
           Js.executeScript("window.scrollBy(0, -1000)", "");
        }


   }

