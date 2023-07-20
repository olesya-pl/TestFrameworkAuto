package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

public class BaseMain {

    public int tab;
    public WebDriver driver;
    public BaseMain (WebDriver driver){
        this.driver = driver;
    }

    public void openNewTab (){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void switchToNewTab(int tab){
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public void scroll(int pixels) {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }
}
