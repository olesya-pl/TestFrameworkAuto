package pageobjects;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMain {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Locators
    public String webSiteURL = "http://test.my-fork.com";

    public String bankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";
    public String signInButton = "//div[@class='home-menu-block']//div[@class='menu']//a[2]";

    public String subscribeButton = "//a[@href='/register']";

     public void clickSignIn () throws InterruptedException{
         openWebSite();;
         driver.findElement(By.xpath(signInButton)).click();
        }
        public void clickSubscribeBTN(){
            driver.findElement(By.xpath(subscribeButton)).click();
        }
    public void openWebSite(){
        driver.get(webSiteURL);
    }
}
