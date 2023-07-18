package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BaseMain {
    public String signInForm;

    public SignInPage(WebDriver driver){

        super(driver);
    }

    public String loginButton = "//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button";
    public String inputEmail = "//div[@class='auth-page-main-block']//form//div[label='Email ']//input";
    public String inputPassword = "//div[@class='auth-page-main-block']//form//div[label='Password ']//input";
    public String textERR ="//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']";
    public String rememberMeCheckBox="//div[@class='form-row auth-page-remember-me-row']//div[text()='Remember Me']";
    public String cheskBox = "auth-page-remember-me";
    public String emailValue ="email@ukr.net";
    String passwordValue ="password";

    public String signInForm(String inputEmail, String inputPassword)
    {
        if ( inputEmail == "//div[@class='auth-page-main-block']//form//div[label='Email ']//input")
        {
        System.out.println(true);}
        else {
            System.out.println(false);
            }
        if (inputPassword == "//div[@class='auth-page-main-block']//form//div[label='Password ']//input")
        {
        System.out.println(true);}
        else {
            System.out.println(false);
            } if (loginButton == "//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button")
        {
        System.out.println(true);}
        else {
            System.out.println(false);
            }
        return signInForm;
    }

    public void fillTheSignInForm(){
        driver.findElement(By.xpath(inputEmail)).sendKeys(emailValue);
        driver.findElement(By.xpath(inputPassword)).sendKeys(passwordValue);
    }

    public void clickLoginBtn(){
        driver.findElement(By.xpath(loginButton)).click();
    }
    public void loginERRIsDisplyed(){
        System.out.println(driver.findElement(By.xpath(textERR)).isDisplayed());
    }
    public void signInFormIsDisplayed(){
        System.out.println(driver.findElement(By.xpath(inputEmail)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(inputPassword )).isDisplayed());
        System.out.println(driver.findElement(By.xpath(loginButton)).isDisplayed());
    }
    public void checkboxTextOnTheSignInPageIsDisplayed(){
        System.out.println(driver.findElement(By.xpath(rememberMeCheckBox)).getText());
    }
    public void validateCheckboxOnTheSignInPage(){
        System.out.print(driver.findElement(By.id(cheskBox)).isSelected());
    }

    public void waitErr(){
        WebDriverWait waitToERRDisplayed = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitToERRDisplayed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textERR)));
    }



}
