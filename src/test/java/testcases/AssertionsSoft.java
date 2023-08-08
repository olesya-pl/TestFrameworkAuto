package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class AssertionsSoft extends BaseTest{
        String actuallySiteTitle;
        String expectedSiteTitle = "My Fork - your educational solution";
        String wrongSiteTitle = "My Fork";
        String actuallyDropDownSize = "//select[@id='job-title']//option[@value]" ;
        int actualDropdownSize;
        int expectedDropdownSize = 14;
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
    @Test (priority = 2, groups = {"next"})
        public void WebSiteTitle() {
            homePage.openWebSite();
            actuallySiteTitle = driver.getTitle();
            softAssert.assertEquals(actuallySiteTitle,expectedSiteTitle, "Title the same");
            softAssert.assertAll();
        }
    @Test (priority = 1, groups = {"menu"})
    public void NotExpectedTheSameSizeOfRolesInDropDownList() {
        homePage.openWebSite();
        homePage.clickSubscribeBTN();
        WebElement searchDropDownElement = driver.findElement(By.xpath(registerPage.dropDown));
        Select dropDown = new Select(searchDropDownElement);
        List<WebElement> elementList = driver.findElements(By.xpath(actuallyDropDownSize));
        actualDropdownSize = elementList.size();
        softAssert.assertNotEquals(actualDropdownSize, expectedDropdownSize, "DropDownSize the same");
        softAssert.assertAll();
    }
    @Test (priority = 1,groups = {"some"})
    public void ValidateError () throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
        signInPage.fillTheSignInForm();
        signInPage.clickLoginBtn();
        Thread.sleep(5000); //by manipulating the number of seconds we can get failed or successful tests. I use numbers 1000 or 5000
        Boolean actuallyErr = driver.findElement(By.xpath("//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']")).isDisplayed();
        softAssert.assertTrue(actuallyErr);
        softAssert.assertAll();
    }
    @Test (priority = 6)
    public void wrongWebSiteTitle() {
        homePage.openWebSite();
        actuallySiteTitle = driver.getTitle();
        softAssert.assertEquals(wrongSiteTitle, expectedSiteTitle);
        System.out.println("Title " + wrongSiteTitle + " is not correct");
        softAssert.assertAll();
    }
}
