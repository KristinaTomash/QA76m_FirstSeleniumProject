package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;
    //before test
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com");//without history
        //driver.navigate().to("https://www.google.com"); with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
    //test
    @Test
    public void openBrowser(){
        System.out.println("Open Google");
    }
    //after test
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();//all tabs and close browser
        //driver.close();// only one tab(if only one tab-> close browser)

    }

}
