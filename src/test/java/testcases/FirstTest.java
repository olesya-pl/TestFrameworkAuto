package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SignInPage;

public class FirstTest extends BaseTest {

    @Test
    public void openSignInPage() throws InterruptedException {
        homePage.clickSignIn();
    }

    @Test
    public void fillEmailAndPasswordAndLogginButtonAreDisplayed() throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(signInPage.inputEmail)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(signInPage.inputPassword)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(signInPage.loginButton)).isDisplayed());
    }
    public void fillEmailAndPasswordFiells() throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
        signInPage.fillTheSignInForm();
    }

    @Test
    public void fillEmailAndPasswordFiellsAndPressEnter() throws InterruptedException {
        fillEmailAndPasswordFiells();
        driver.findElement(By.xpath(signInPage.loginButton)).click();
    }

    public void fillInNewCredentials (String email, String password){
        driver.findElement(By.xpath(signInPage.inputEmail)).sendKeys("123ewa@ukr.net");
        driver.findElement(By.xpath(signInPage.inputPassword)).sendKeys("12password21");
    }

    @Test
    public void fillEmailAndPasswordFiellsAndValidateError() throws InterruptedException {
        openSignInPage ();
        Thread.sleep(1000);
        fillInNewCredentials ("wiki@gmail.com", "a714587");
        driver.findElement(By.xpath(signInPage.inputPassword)).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath(signInPage.textERR)).isDisplayed());
    }

    @Test
    public void fillEmailAndPasswordFiellsAndValidateCheckbox() throws InterruptedException {
        openSignInPage ();
        System.out.print(driver.findElement(By.id(signInPage.cheskBox)).isSelected());
    }

    @Test
    public void verifyCheckboxText() throws InterruptedException {
        openSignInPage ();
        System.out.println(driver.findElement(By.xpath(signInPage.rememberMeCheckBox)).getText());
    }

    @Test
    public void isEnabled() throws InterruptedException {
        driver.get("https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG");
        driver.findElement(By.xpath("//h3[text()='Everyday Banking']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("button.topicSpartaUILayerClose")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("button.nextBtnSubTopics")).isEnabled());
    }
}
