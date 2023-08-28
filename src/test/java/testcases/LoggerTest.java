package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoggerTest extends BaseTest{
    public String loginButton = "//div[@class='auth-page-main-block']//form//div[@id='loginButton']//button";
    public String inputEmail = "//div[@class='auth-page-main-block']//form//div[label='Email ']//input";
    public String inputPassword = "//div[@class='auth-page-main-block']//form//div[label='Password ']//input";
    public String emailValue ="email@ukr.net";
    String passwordValue ="password";
    public  String url = "http://test.my-fork.com/login";
   @Test
   public void testlogInfoInsignInFormUsingXpath(){
       signInPage.logInfoInsignInFormUsingXpath();
   }
   @Test
   public void testlogInfoInsignInFormUsingLoginBtnAsWebElement(){
       signInPage.logInfoUsingLoginBtnAsWebElement();
   }  @Test
   public void testlogInfoInsignInFormUsingLoginAfterWait() throws InterruptedException {
       signInPage.logInfoInsignInFormUsingXpathAfterWait();
   }
}
