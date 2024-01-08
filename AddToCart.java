package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCart {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void searchAndAddItemToCart() {
   
        WebElement searchBox = driver.findElement(By.id("gh-search-input"));
        searchBox.sendKeys("laptop");
        searchBox.sendKeys(Keys.ENTER);

     
        WebElement product = driver.findElement(By.cssSelector(".sku-title a"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-button"));
        addToCartButton.click();

        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
