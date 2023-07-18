package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends BaseMain {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String dropDown = "//select[@id='job-title']";
    WebElement dropDownElement;


    public void findDropDown() {
     driver.findElement(By.xpath(dropDown));
    }
}
