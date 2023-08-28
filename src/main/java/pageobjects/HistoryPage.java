package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class HistoryPage extends BaseMain {

    public HistoryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    By actuallyList = By.xpath( "//div[@class='expertise-areas-list']//div[@data-expertise-name]");

    public void menuOptionsVerification() {
        List<WebElement> menuElementList = driver.findElements(actuallyList);
        List<String> menuOptions = new ArrayList<>();
        for (int i = 0; i < menuElementList.size(); i++) {
            String text = menuElementList.get(i).getText();
            menuOptions.add(text);
        }
        log.info("actually list of menu options is:" +menuOptions);
        log.info("expected list of menu options is:" +expectedList);

        Assert.assertEquals(menuOptions,expectedList);
        log.info("The lists " + menuOptions+ " and " + expectedList + " are equal");
    }

    public  List <String> expectedList = Arrays.asList("Development", "Testing", "Business Analyst", "Agile", "Project Management");

    public int actualSize;
    public int expectedListSize = 5;

    public By totalNumberOfQuestions = By.xpath("//div[@class='quiz-process-questions']//*[contains(@class,'quiz-process-questions-button ')]");
    public By answer = By.xpath( "//div[contains(@class, 'quiz-process-questions-button') and (contains(@class, 'answered'))]");
    public String startButton;
    public String historyButton = "//a[@class = 'quiz-section-history-button']";

    public String startButton(String coursevalue) {
        return startButton;
    }

    public String numberOfAnswer = "//div[@data-answer-id={numberOfAnswer}]";
    By progress_bar = By.xpath("//div[@id='quiz-process-progress-data']");

    public void clickOnTheStartButton() {
        driver.findElement(By.xpath("//div[contains(@class, 'quiz-item-list-item new ') and not(contains(@class, 'hidden'))][1]//div[@class= 'quiz-item-button']")).click();
        log.info(" Start button was successfully clicked ");
    }

    public void clickOnTheFirstAnswer() {
        driver.findElement(By.xpath("//div[@class='quiz-process-question-block-answers-block-item-numbering'][text()[contains(.,'A')]]")).click();
        log.info(" the first answer was successfully clicked ");
    }

    public int historyButtonAValidation() {
        if (historyButton() == 0) {
        log.info("History button is absent on the page");
        } else {
         log.info("History button is present on the page");
        }
        return historyButton();
    }

    public int historyButton(){
        int History = driver.findElements(By.xpath("//a[@class = 'quiz-section-history-button']")).size();
        return History;
    }
//    public void historyButton() {
//        List<WebElement> history_btn = driver.findElements(By.xpath("//a[@class = 'quiz-section-history-button']"));
//        System.out.println(history_btn);
//        Assert.assertTrue(history_btn.isEmpty());
//    }

    public void switchToNewTab(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public float getTotalNumberOfQuestions() {
        List<WebElement> quantityOfQuestions = driver.findElements((By) totalNumberOfQuestions);
       int totalNumberOfQuestions = quantityOfQuestions.size();
       // System.out.println(" Quantity of Total Questions = "  + totalNumberOfQuestions);
        return totalNumberOfQuestions;
    }

    public float getAnsweredQuestions() {
        List<WebElement> answeredQuestions = driver.findElements(answer);
       // System.out.println(" Quantity of Answered Questions = " + answer );
       int answer = answeredQuestions.size();
        return answer;
    }

    public String getProgressBarAfterAnswer() {
        String progress = driver.findElement(progress_bar).getText();
        String result = progress.substring(0, progress.length() - 1);
        //log.info(" Progress Bar After Answer = "+ result+ " %");
        return result;
    }

       public String getProgressBarValue() {
       //correct value = number of answered questions / total number of questions
           String validationProgressBar  = String.valueOf(100*(getAnsweredQuestions()/getTotalNumberOfQuestions()));
          // log.info(validationProgressBar + " % after answer №" + getAnsweredQuestions());
           String result = (validationProgressBar.substring(0, validationProgressBar.indexOf(".")));
           return result;}

    public void verifycationActuallyAndExpectedProgressBar(){
        Assert.assertEquals(getProgressBarValue(), getProgressBarAfterAnswer());
        log.info("Actually progress bar after answer № " + getAnsweredQuestions() + " = " + getProgressBarValue() + " %");
        log.info("Estimated progress bar = " + getProgressBarAfterAnswer() + " %");
    }

    public void clickOnTheNextButton(){
        driver.findElement(By.xpath("//div[contains(text(),'Next')]")).click();
        log.info("Next Button was clicked successfully ");
    }
}

