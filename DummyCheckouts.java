package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DummyCheckouts {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void checkoutAndFillPayment() {
       
        driver.get("https://www.bestbuy.com/cart");

        
        WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));
        checkoutButton.click();

      
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("K");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Madhu");

        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("321 Street");

        WebElement cardNumberInput = driver.findElement(By.id("credit-card-number"));
        cardNumberInput.sendKeys("123546758963542");

        WebElement expiryInput = driver.findElement(By.id("expiration-date"));
        expiryInput.sendKeys("12/25");

        

        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Place Your Order')]"));
        placeOrderButton.click();

       
        try {
            Thread.sleep(5000);
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
