package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RequestsAndResponsesTests extends BaseTest{
    @Test
    public void urlVerification(){
        homePage.openWebSite();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();   //Cannot invoke "String.length()" because "spec" is null
    }

    @Test
    public void urlVerificationForAmazon(){
        homePage.openAmazon();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll(); // Failed
    }

    @Test
    public void urlVerificationForYouTube(){
        homePage.openYoutube();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll(); // Cannot invoke "String.length()" because "spec" is null
    }
    @Test
    public void urlVerificationForPrephouse(){
        homePage.openPrephouse();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();  //Cannot invoke "String.length()" because "spec" is null
    }

    @Test
    public void urlVerificationForWikipedia(){
        homePage.openWikipedia();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();  //Passed successfully
    }

    @Test
    public void urlVerificationForZo(){
        homePage.openZo();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();
    }
    @Test
    public void urlVerificationForQaGroup(){
        homePage.openQaGroup();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();  // Was found code 999. What is that?
    }
}
