package testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FirstTest extends BaseTest {

   @Test
    public void openWebSite(){
       homePage.openWebSite();
   }
    @Test
      public void openSignInPage() throws InterruptedException {
        homePage.clickSignIn();
    }
    @Test
    public void EmailPasswordAndLogginButtonAreDisplayed() throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
       signInPage.signInFormIsDisplayed();
   }

    @Test
    public void fillEmailAndPasswordFiells() throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
        signInPage.fillTheSignInForm();
    }


    public void fillEmailAndPasswordFiellsAndPressLoginBtn() throws InterruptedException {
        fillEmailAndPasswordFiells();
        signInPage.clickLoginBtn();
   }

    @Test
    public void fillEmailAndPasswordFiellsAndValidateError() throws InterruptedException {
        openSignInPage ();
        Thread.sleep(1000);
        fillEmailAndPasswordFiellsAndPressLoginBtn();
        Thread.sleep(5000);
        signInPage.loginERRIsDisplyed();
    }
    @Test
    public void fillEmailAndPasswordFiellsAndValidateCheckbox() throws InterruptedException {
        openSignInPage ();
        signInPage.validateCheckboxOnTheSignInPage();
    }
    @Test
    public void verifyCheckboxText() throws InterruptedException {
        openSignInPage ();
        signInPage.checkboxTextOnTheSignInPageIsDisplayed();
    }

    @Test
    public void validateRolesInDropDown() throws InterruptedException {
        openWebSite();
        homePage.clickSubscribeBTN();
        WebElement searchDropDownElement;
        searchDropDownElement = driver.findElement(By.xpath(registerPage.dropDown));
        Select dropDown = new Select(searchDropDownElement);
        List<WebElement> options = new ArrayList<>();
        options = dropDown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
    }

        @Test
        public void ValidateErrorWithWaiting () throws InterruptedException {
            fillEmailAndPasswordFiellsAndPressLoginBtn();
            signInPage.waitErr();
        }

   }

