package com.test.project;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BestBuyTwo {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      
    }
    
    @Test(priority = 1)
    public void navigateAndInteractWithBestBuy() {
        try {
            driver.get("https://www.bestbuy.com/");

            System.out.println("Page title is: " + driver.getTitle());

            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                System.out.println(link.getText());
            }

            WebElement searchBox = driver.findElement(By.id("gh-search-input"));
            searchBox.sendKeys("laptop");
            searchBox.submit();

            WebElement product = driver.findElement(By.cssSelector(".sku-title a"));
            product.click();

            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}