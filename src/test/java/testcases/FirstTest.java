package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\IdeaProjects\\TestAutomationFramework\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
    }
    @Test
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://mvnrepository.com/artifact/org.testng/testng");
    }
}
