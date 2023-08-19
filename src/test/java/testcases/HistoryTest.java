package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HistoryTest extends BaseTest {

    @Test
    public void validateHistory () throws InterruptedException {
        homePage.openWebSite();
        homePage.siteName();
        baseMain.clickUsingXpath(homePage.GalleryButton, "Gallery Button");
        historyPage.historyButtonAValidation();
        driver.navigate().back();
        baseMain.clickUsingXpath(homePage.signInButton,"Sign In button");
        signInPage.logInfoInsignInFormUsingXpath();
        baseMain.clickUsingXpath(homePage.GalleryButton, "Gallery Button");
        historyPage.historyButtonAValidation();
    }

    @Test
    public void courseGalleryOptionsVerification() {
        homePage.openWebSite();
        homePage.siteName();
        baseMain.clickUsingXpath(homePage.GalleryButton, "Gallery Button");
        historyPage.menuOptionsVerification();
    }
    @Test
    public void progressBar () {
         homePage.openWebSite();
         homePage.siteName();
         baseMain.clickUsingXpath(homePage.GalleryButton, "Gallery Button");
         historyPage.clickOnTheStartButton();
         baseMain.switchToNewTab(1);
         System.out.println(" Quantity of Total Questions = "  + historyPage.getTotalNumberOfQuestions());
         historyPage.clickOnTheFirstAnswer();
         System.out.println(" Quantity of Answered Questions = " + historyPage.getAnsweredQuestions() );
         historyPage.verifycationActuallyAndExpectedProgressBar();
         historyPage.clickOnTheNextButton();
         historyPage.verifycationActuallyAndExpectedProgressBar();
         historyPage.clickOnTheFirstAnswer();
         historyPage.verifycationActuallyAndExpectedProgressBar();
        }
    }


