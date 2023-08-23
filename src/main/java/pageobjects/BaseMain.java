package pageobjects;

import org.openqa.selenium.*;

import java.net.HttpURLConnection;
import java.net.URL;
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

    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }


        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }


}
