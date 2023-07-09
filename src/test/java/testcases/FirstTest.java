package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

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
}
