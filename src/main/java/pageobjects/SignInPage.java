package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BaseMain {
    public SignInPage(WebDriver driver){

        super(driver);
    }

    public String loginButton = "//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button";
    public String inputEmail = "//div[@class='auth-page-main-block']//form//div[label='Email ']//input";
    public String inputPassword = "//div[@class='auth-page-main-block']//form//div[label='Password ']//input";
    public String textERR ="//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']";
    public String rememberMeCheckBox="//div[@class='form-row auth-page-remember-me-row']//div[text()='Remember Me']";
    public String cheskBox = "auth-page-remember-me";
    String emailValue ="email@ukr.net";
    String passwordValue ="password";

    public void fillTheSignInForm(){
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Email ']//input")).sendKeys("email@ukr.net");
        driver.findElement(By.xpath("//div[@class='auth-page-main-block']//form//div[label='Password ']//input")).sendKeys("password");
    }
}
