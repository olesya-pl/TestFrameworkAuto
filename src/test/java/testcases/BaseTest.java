package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import pageobjects.SignInPage;

import java.time.Duration;
import java.util.Optional;

public class BaseTest {

    public ChromeDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;

    @BeforeMethod
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        registerPage= new RegisterPage(driver);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

      // I used this for test "ValidateErrorWithWaiting"
      //  DevTools devTools = ((ChromeDriver)driver).getDevTools();
      //  devTools.createSession();
      //   devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
      //  devTools.send(Network.emulateNetworkConditions(false,1000, 100000, 100000, Optional.empty()));
    }

   @AfterMethod
  public void closeBrowser() {
        driver.close();
    }
}
