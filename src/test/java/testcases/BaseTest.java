package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.SignInPage;

public class BaseTest {

    public ChromeDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }

   @AfterMethod
  public void closeBrowser() {

       driver.close();
    }
}
