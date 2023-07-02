package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    public ChromeDriver driver;
    protected String webSiteURL = "http://test.my-fork.com/";
    public void signInOnTheSite () {
        driver.get(webSiteURL);
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
    }

    @BeforeMethod
    public void setUp (){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
}

    @Test
    public void openWebsite() {
        driver.get(webSiteURL);
    }
    @Test
    public void openSignInPage() throws InterruptedException {
        signInOnTheSite ();
    }

    @Test
    public void fillEmailAndPasswordAndLogginButtonAreDisplayed() throws InterruptedException {
        signInOnTheSite ();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Email ']//input")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Password ']//input")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button")).isDisplayed());
    }

    public void  fillInCredentials (String email, String password){
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Email ']//input")).sendKeys("email@ukr.net");
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Password ']//input")).sendKeys("password");
    }

    @Test
    public void fillEmailAndPasswordFiells() throws InterruptedException {
        signInOnTheSite ();
        Thread.sleep(1000);
        fillInCredentials ("1222@gmail.com", "123554788");
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button")).submit();
    }

    @Test
    public void fillEmailAndPasswordFiellsAndPressEnter() throws InterruptedException {
        signInOnTheSite ();
        Thread.sleep(1000);
        fillInCredentials ("18pikm@gmail.com", "adfggh");
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Password ']//input")).sendKeys(Keys.ENTER);
    }

    @Test
    public void fillEmailAndPasswordFiellsAndValidateError() throws InterruptedException {
        signInOnTheSite ();
        Thread.sleep(1000);
        fillInCredentials ("wiki@gmail.com", "a714587");
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Password ']//input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']")).isDisplayed());
    }

    @Test
    public void fillEmailAndPasswordFiellsAndValidateCheckbox() throws InterruptedException {
        signInOnTheSite ();
        System.out.print(driver.findElement(By.id("auth-page-remember-me")).isSelected());
    }

    @Test
    public void verifyCheckboxText() throws InterruptedException {
        signInOnTheSite ();
        System.out.println(driver.findElement(By.xpath("//div[@class='form-row auth-page-remember-me-row']//div[text()='Remember Me']")).getText());
    }

    /**
     *  Closing the browser
     */

    @AfterMethod
    public void closeBrowser() {
        driver.close();
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
