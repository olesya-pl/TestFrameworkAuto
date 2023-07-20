package testcases;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pageobjects.BaseMain;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DriverInteractions extends BaseTest{
    @Test
    public void switchToTabTest (){
        driver.get(homePage.webSiteURL);
        baseMain.openNewTab();
        baseMain.openNewTab();
        baseMain.openNewTab();
        baseMain.openNewTab();
        baseMain.openNewTab();
        baseMain.switchToNewTab(2);
        driver.navigate().to("http://amazon.com");
    }


       @Test
  public void scrollTest() throws InterruptedException{
           driver.get(homePage.webSiteURL);
           baseMain.scroll(3000);
           Thread.sleep(1000);
           baseMain.scroll(-2000);
        }


   }

