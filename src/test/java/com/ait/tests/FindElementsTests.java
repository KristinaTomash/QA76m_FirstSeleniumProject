package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");

        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(900,400));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void findElementByTagNameTest() {
        //Find ONE element
        //find by tag - h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //find by tag - h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //find by tag - a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        // //find by tag - label
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());

        //find list of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }
    @Test
    public void findElementByLinkText(){
        WebElement linkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(linkText.getText());

    }
    @Test
    public void findElementByPartialLinkText(){
        WebElement partialLink = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLink.getText());
    }
        @Test
        public void findElementByCssSelector(){
        //driver.findElement(By.tagName("h1"));
            //tag name 'h1'->css 'h1'
            driver.findElement(By.cssSelector("h1"));
        //driver.findElement(By.id("city"));
            //id 'city'-> css '#city'
            driver.findElement(By.cssSelector("#city"));

            //driver.findElement(By.className("telephone"));
            //className "telephone" -> css ".telephone"
            driver.findElement(By.cssSelector(".telephone"));

            // [attr='par']
            WebElement element = driver.findElement(By.cssSelector("[href='/search']"));
            System.out.println(element.getText());

            driver.findElement(By.cssSelector("[for='city']"));

            //contains ->*
            driver.findElement(By.cssSelector("[href*='car']"));
            //start -> ^
            driver.findElement(By.cssSelector("[href^='/let']"));
            //end to -> $
            driver.findElement(By.cssSelector("[href$='work']"));

            //composite cssSelector(tag+class+pare)
            driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
            //composite cssSelector(tag+class)
            driver.findElement(By.cssSelector("div.social-networks"));
            //> one step below
            driver.findElement(By.cssSelector(".logo>img"));
            // <space> one or more steps  below ????
            driver.findElement(By.cssSelector(".feedback-card .feedback-date"));
            //<tag> or <id> or <class>:nth-child(n)
            WebElement element1 = driver.findElement(By.cssSelector(".search-container:nth-child(1)"));
            System.out.println(element1.getText());
        }


    @AfterMethod(enabled = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

}