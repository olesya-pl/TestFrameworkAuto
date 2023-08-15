package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;

import java.time.Duration;

public class BaseTest {

    public ChromeDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;
    BaseMain baseMain;
    HistoryPage historyPage;

    @BeforeMethod ()
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        registerPage= new RegisterPage(driver);
        baseMain = new BaseMain(driver);
        historyPage = new HistoryPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      // I used this for test "ValidateErrorWithWaiting"
      //  DevTools devTools = ((ChromeDriver)driver).getDevTools();
      //  devTools.createSession();
      //   devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
      //  devTools.send(Network.emulateNetworkConditions(false,1000, 100000, 100000, Optional.empty()));
    }

   @AfterMethod ()
  public void closeBrowser() {
       // driver.quit();
    }
}
