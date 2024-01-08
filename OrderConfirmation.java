package com.test.project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderConfirmation{
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void verifyOrderConfirmation() {
    	
    	  WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Place Your Order')]"));
          placeOrderButton.click();

        

        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Your order has been successfully placed')]"));

        Assert.assertTrue(confirmationMessage.isDisplayed(), "Order placement verification failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
