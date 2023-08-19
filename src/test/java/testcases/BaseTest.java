package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    public ChromeDriver driver;
    Logger log;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;
    BaseMain baseMain;
    HistoryPage historyPage;

    @BeforeMethod
    public void setUp () throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        log = Logger.getLogger(getClass().getName());
        savelogs(log);
        homePage = new HomePage(driver, log);
        signInPage = new SignInPage(driver, log);
        registerPage= new RegisterPage(driver, log);
        baseMain = new BaseMain(driver, log);
        historyPage = new HistoryPage(driver, log);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      // I used this for test "ValidateErrorWithWaiting"
      //  DevTools devTools = ((ChromeDriver)driver).getDevTools();
      //  devTools.createSession();
      //   devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
      //  devTools.send(Network.emulateNetworkConditions(false,1000, 100000, 100000, Optional.empty()));
    }

   @AfterMethod
  public void closeBrowser() {
        driver.quit();
    }

    public void savelogs(Logger log) throws IOException {
        FileHandler fileHandler;
        fileHandler = new FileHandler("C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("This is the beginning of the test suit");
    }
}
