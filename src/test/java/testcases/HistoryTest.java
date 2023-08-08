package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;


public class HistoryTest extends BaseTest {
    SoftAssert softAssert = new org.testng.asserts.SoftAssert();

    String actuallyListSize = "//div[@class='expertise-areas-list']//div[@data-expertise-name]";
    int actualSize;
    int expectedListSize = 5;

    public String totalNumberOfQuestions = "//div[@class='quiz-process-questions']//*[contains(@class,'quiz-process-questions-button ')]";

    public String answer = "//div[contains(@class, 'quiz-process-questions-button') and (contains(@class, 'answered'))]";
    public String startButton;

    public String startButton(String coursevalue) {
        return startButton;
    }
    public String numberOfAnswer = "//div[@data-answer-id={numberOfAnswer}]";

   // public int progressBar;

    public String percentOfProgressBar = "//div[@id='quiz-process-progress-data']";

     int progressBarAfterAnswer(){
        System.out.println(percentOfProgressBar);
        int result = Integer.valueOf(percentOfProgressBar.substring(0,percentOfProgressBar.indexOf("%")));
        return result;
     }

        public void clickOnTheStartButton() {
        driver.findElement(By.xpath("//div[contains(@class, 'quiz-item-list-item new ') and not(contains(@class, 'hidden'))][1]//div[@class= 'quiz-item-button']")).click();
    }


    public void clickOnTheFirstAnswer() {
        driver.findElement(By.xpath("//div[@class='quiz-process-question-block-answers-block-item-numbering'][text()[contains(.,'A')]]")).click();}

    public boolean actuallyResult() {
        try {
           WebElement actuallyResult = driver.findElement(By.xpath("//a[@class = 'quiz-section-history-button']"));
           actuallyResult.isDisplayed();
            }
        catch (Exception e){
            System.out.println("The element HistoryButton are absent on the page");        }
            {
                return true;
            }
    }

    public void switchToNewTab(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));}

    public int getTotalNumberOfQuestions(){
        List <WebElement> quantityOfQuestions = driver.findElements(By.xpath(totalNumberOfQuestions));
        totalNumberOfQuestions = String.valueOf((quantityOfQuestions.size()));
        System.out.println(quantityOfQuestions.size());
        return quantityOfQuestions.size();
    }

   public int getAnsweredQuestions(){
        List <WebElement> answeredQuestions = driver.findElements(By.xpath(answer));
        answer = String.valueOf(answeredQuestions.size());
       System.out.println(answeredQuestions.size());
        return answeredQuestions.size();

    }

    public int getProgressBarValue()
     {
        //correct value = number of answered questions / total number of questions
      int progressBar = (getAnsweredQuestions()/getTotalNumberOfQuestions())*100;
      System.out.println(progressBar);
      return getProgressBarValue();
    }

    @Test
    public void validateHistory () throws InterruptedException {
        homePage.openWebSite();
        homePage.clickOnCourseGalleryButton();
        softAssert.assertTrue(actuallyResult());
        driver.navigate().back();
        homePage.clickSignIn();
        signInPage.fillUnickEmailAndassword("testing@my-fork.com", "Password");
        signInPage.clickLoginBtn();
        homePage.clickOnCourseGalleryButton();
        Boolean actuallyResult = driver.findElement(By.xpath("//a[@class = 'quiz-section-history-button']")).isDisplayed();
        Boolean expectedResalt = driver.findElement(By.xpath("//a[@class = 'quiz-section-history-button']")).isDisplayed();
        softAssert.assertEquals(actuallyResult, expectedResalt);
        softAssert.assertAll();
    }

    @Test
    public void courseGalleryOptions () {
        homePage.openWebSite();
        homePage.clickOnCourseGalleryButton();
        List<WebElement> elementList = driver.findElements(By.xpath(actuallyListSize));
        actualSize = elementList.size();
        for (WebElement option : elementList) {
            System.out.println(option.getText());
        }
        System.out.println(actualSize);
        softAssert.assertEquals(actualSize, expectedListSize);
        softAssert.assertAll();
    }
        @Test
        public void progressBar () {
            homePage.openWebSite();
            homePage.clickOnCourseGalleryButton();
            clickOnTheStartButton();
            switchToNewTab(1);
            getTotalNumberOfQuestions();
            clickOnTheFirstAnswer();
            getAnsweredQuestions();
            getProgressBarValue();
            softAssert.assertEquals(getProgressBarValue(), progressBarAfterAnswer());
        }
    }


