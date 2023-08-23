package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class HomePage extends BaseMain {
    //public boolean historyButtonPresentOnThePage;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Locators
    public String webSiteURL = "http://test.my-fork.com";
    public String Amazon= "https://www.amazon.com/";
    public String YouTube= "https://www.youtube.com/";
    public String Prephouse= "https://prephouse.thinkific.com/";
    public String wikipedia= "https://en.wikipedia.org/wiki/Main_Page";
    public String zo= "https://zoskinhealth.com/";
    public String qagroup= "https://qagroup.com.ua/";


    public String bankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";
    public String signInButton = "//div[@class='home-menu-block']//div[@class='menu']//a[2]";

    public String subscribeButton = "//a[@href='/register']";
    public String GalleryButton = "//a[@href='/quizzes-list']";

     public void clickSignIn () throws InterruptedException{
         openWebSite();
         driver.findElement(By.xpath(signInButton)).click();
        }

    public void clickSignInBtnUsingXpath() {
        clickUsingXpath(signInButton,"Sign In  button");
    }
        public void clickSubscribeBTN(){
            driver.findElement(By.xpath(subscribeButton)).click();
        }
    public void openWebSite(){
        driver.get(webSiteURL);
    }
    public void openAmazon(){
        driver.get(Amazon);
    }
    public void openYoutube(){
        driver.get(YouTube);
    }
    public void openPrephouse(){
        driver.get(Prephouse);
    }
    public void openWikipedia(){
        driver.get(wikipedia);
    }
    public void openZo(){
        driver.get(zo);
    }
    public void openQaGroup(){
        driver.get(qagroup);
    }
    public  String siteName() {
        log.info("WebSite "+ webSiteURL+ " is opened successfully");
        return null;
    }

    public WebElement historyButton() {
        driver.findElement(By.xpath("//a[@class='quiz-section-history-button']"));
        return historyButton();
    }
    public Boolean historyButtonPresentOnThePage() {
        Boolean historyButtonPresentOnThePage = driver.findElement(By.xpath("//a[@class='quiz-section-history-button']")).isDisplayed();
        return historyButtonPresentOnThePage;
    }
    public void clickOnCourseGalleryButton() {
        driver.findElement(By.xpath("//a[@href='/quizzes-list']")).click();
    }


    public List<Integer> urlVerification() {
        return verifyLinkActive();
    }
}
