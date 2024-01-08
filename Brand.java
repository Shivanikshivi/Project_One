package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Brand {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void addItemFromBrands() {
       
        WebElement menuElement = driver.findElement(By.id("menuButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuElement).perform();

       
        WebElement brandsLink = driver.findElement(By.xpath("//a[contains(text(),'Brands')]"));
        brandsLink.click();

       
        WebElement dellBrand = driver.findElement(By.xpath("//a[contains(text(),'Dell')]"));
        dellBrand.click();

        
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