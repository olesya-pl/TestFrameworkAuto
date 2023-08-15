package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HistoryTest extends BaseTest {

    @Test
    public void validateHistory () throws InterruptedException {
        homePage.openWebSite();
        homePage.clickOnCourseGalleryButton();
        historyPage.historyButton();
        driver.navigate().back();
        homePage.clickSignIn();
        signInPage.fillUnickEmailAndassword("testing@my-fork.com", "Password");
        signInPage.clickLoginBtn();
        homePage.clickOnCourseGalleryButton();
        Boolean actuallyResult = driver.findElement(By.xpath("//a[@class = 'quiz-section-history-button']")).isDisplayed();
        Boolean expectedResalt = driver.findElement(By.xpath("//a[@class = 'quiz-section-history-button']")).isDisplayed();
        Assert.assertEquals(actuallyResult, expectedResalt);
    }

    @Test
    public void courseGalleryOptionsValidation () {
        homePage.openWebSite();
        homePage.clickOnCourseGalleryButton();
        historyPage.menuOptionsVerification();
    }
        @Test
        public void progressBar () {
            homePage.openWebSite();
            homePage.clickOnCourseGalleryButton();
            historyPage.clickOnTheStartButton();
            baseMain.switchToNewTab(1);
            System.out.println(" Quantity of Total Questions = "  + historyPage.getTotalNumberOfQuestions());
            historyPage.clickOnTheFirstAnswer();
            System.out.println(" Quantity of Answered Questions = " + historyPage.getAnsweredQuestions() );
            historyPage.getProgressBarAfterAnswer();
            historyPage.getProgressBarValue();
            Assert.assertEquals(historyPage.getProgressBarValue(), historyPage.getProgressBarAfterAnswer());
            System.out.println("Actually progress bar after answer № " + historyPage.getAnsweredQuestions() + " = " + historyPage.getProgressBarValue());
            System.out.println("Estimated progress bar = " + historyPage.getProgressBarAfterAnswer());
            historyPage.clickOnTheNextButton();
            Assert.assertEquals(historyPage.getProgressBarValue(), historyPage.getProgressBarAfterAnswer());
            System.out.println("Progress bar after answer № " + historyPage.getAnsweredQuestions() + " = " + historyPage.getProgressBarValue());
            System.out.println("Estimated progress bar = " + historyPage.getProgressBarAfterAnswer());
            historyPage.clickOnTheFirstAnswer();
            Assert.assertEquals(historyPage.getProgressBarValue(), historyPage.getProgressBarAfterAnswer());
            System.out.println("Actually progress bar after answer № " + historyPage.getAnsweredQuestions() + " = " + historyPage.getProgressBarValue());
            System.out.println("Estimated progress bar = " + historyPage.getProgressBarAfterAnswer());
        }
    }


