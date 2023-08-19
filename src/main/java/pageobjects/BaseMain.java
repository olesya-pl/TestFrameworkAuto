package pageobjects;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {

    public WebDriver driver;
    public Logger log;
    public BaseMain (WebDriver driver, Logger logger){
        this.driver = driver;
        this.log = logger;
    }

    public void openNewTab (){

        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchToNewTab(int tab){
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
        log.info(" switched to tab #" +tab+ " was successfully");
        }

    public void scroll(int pixels) {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }
    public void clickUsingXpath(String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element " + elementName + " was successfully clicked");
    }
    public void clickUsingWebElement(WebElement element, String elementName){
        element.click();
        log.info("Element " + elementName + " was successfully clicked");
    }
    public void typeUsingXpath(String xpath, String element, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value " + value + " was successfully entered into "+ element+ " element");
    }
    public void clickUsingXpathAfterWait(String xpath, String elementName) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element " + elementName + " was successfully clicked");
    }




}
