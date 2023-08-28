package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class HardAssert extends BaseTest {

    String actuallySiteTitle;
    String expectedSiteTitle = "My Fork - your educational solution";
    String wrongSiteTitle = "My Fork";
    String actuallyDropDownSize = "//select[@id='job-title']//option[@value]" ;

    int actualDropdownSize;
    int expectedDropdownSize = 13;

      @Test(priority = 2)
    public void WebSiteTitle() {
        homePage.openWebSite();
        actuallySiteTitle = driver.getTitle();
        Assert.assertEquals(actuallySiteTitle, expectedSiteTitle);
        System.out.println("Title " + actuallySiteTitle + " is correct");
    }
    @Test (priority = 2, groups = {"next"})
    public void SizeOfRolesInDropDownList() {
        homePage.openWebSite();
        homePage.clickSubscribeBTN();
        WebElement searchDropDownElement;
        searchDropDownElement = driver.findElement(By.xpath(registerPage.dropDown));
        Select dropDown = new Select(searchDropDownElement);
        List<WebElement> elementList = driver.findElements(By.xpath(actuallyDropDownSize));
        actualDropdownSize = elementList.size();
        Assert.assertEquals(actualDropdownSize, expectedDropdownSize);
        }

    @Test(priority = 1, groups = {"menu"})
    public void ValidateError () throws InterruptedException {
        homePage.clickSignIn();
        Thread.sleep(1000);
        signInPage.fillTheSignInForm();
        signInPage.clickLoginBtn();
        Thread.sleep(5000); // by manipulating the number of seconds we can get failed or successful tests. I use numbers 1000 or 5000
        Boolean actuallyErr = driver.findElement(By.xpath("//div[@class='auth-page-main-block']//div[@class='test-login-errors']//p[text()='Error: email is incorrect']")).isDisplayed();
        assertTrue(actuallyErr);
            }

    @Test (groups = {"some"})
    public void wrongWebSiteTitle() {
        homePage.openWebSite();
        actuallySiteTitle = driver.getTitle();
        Assert.assertEquals(wrongSiteTitle, expectedSiteTitle);
        System.out.println("Title " + wrongSiteTitle + " is not correct");
    }
    }