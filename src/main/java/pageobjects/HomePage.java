package pageobjects;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMain {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Locators
    String webSiteURL = "http://test.my-fork.com/";
    String bankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";
    String signInButton = "//div[@class='home-menu-block']//div[@class='menu']//a[2]";

     public void clickSignIn () throws InterruptedException{
            driver.get(webSiteURL);
            driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        }
    }
