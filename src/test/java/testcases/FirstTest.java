package testcases;

import com.sun.source.util.SourcePositions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
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

    @Test (priority = 1, groups = {"some"})
    public void fillEmailAndPasswordFiellsAndValidateError() throws InterruptedException {
        openSignInPage ();
        Thread.sleep(1000);
        fillEmailAndPasswordFiellsAndPressLoginBtn();
        Thread.sleep(5000);
        signInPage.loginERRIsDisplyed();
    }
    @Test (priority = 2, groups = {"next"})
    public void fillEmailAndPasswordFiellsAndValidateCheckbox() throws InterruptedException {
        openSignInPage ();
        signInPage.validateCheckboxOnTheSignInPage();
    }
    @Test (priority = 4, groups = {"menu"})
    public void verifyCheckboxText() throws InterruptedException {
        openSignInPage ();
        signInPage.checkboxTextOnTheSignInPageIsDisplayed();
    }

    @Test (priority = 3, groups = {"next"})
    public void validateRolesInDropDown() {
        openWebSite();
        homePage.clickSubscribeBTN();
        WebElement searchDropDownElement;
        searchDropDownElement = driver.findElement(By.xpath(registerPage.dropDown));
        Select dropDown = new Select(searchDropDownElement);
        List<WebElement> options;
        options = dropDown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

        @Test (priority = 5, groups = {"next"})
        public void ValidateErrorWithWaiting () throws InterruptedException {
            fillEmailAndPasswordFiellsAndPressLoginBtn();
            signInPage.waitErr();
        }

   }

