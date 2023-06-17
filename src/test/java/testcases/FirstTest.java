package testcases;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\IdeaProjects\\TestAutomationFramework\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
    }

    @Test
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://mvnrepository.com/artifact/org.testng/testng");
    }

    @Test
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
    }
    @Test
    public void openSignInPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
    }
    @Test
    public void fillEmailAndPasswordAndLogginButtonAreDisplayed() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@id='loginButton']")).isDisplayed());
    }
    @Test
    public void fillEmailAndPasswordFiells() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@ukr.net");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//div[@id='loginButton']")).submit();
    }
    @Test
    public void fillEmailAndPasswordFiellsAndValidateError() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@ukr.net");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']")).isDisplayed());
    }
    @Test
    public void fillEmailAndPasswordFiellsAndValidateCheckbox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        System.out.print(driver.findElement(By.id("auth-page-remember-me")).isSelected());
    }
    @Test
    public void verifyCheckboxText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\opylypiv\\Desktop\\TestFrameworkAuto\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='home-menu-block']//div[@class='menu']//a[2]")).click();
        System.out.print(driver.findElement(By.xpath("//div[@class='form-row auth-page-remember-me-row']//div[text()='Remember Me']")).getText());
    }
}
