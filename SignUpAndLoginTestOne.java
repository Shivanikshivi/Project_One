package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpAndLoginTestOne {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void signUpAndLoginTest() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[2]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"account-menu-account-button\"]/span")).click();
        driver.findElement(By.xpath("//a[href='/identity/global/signin']")).click();

        driver.findElement(By.id("fld-e")).sendKeys("shivanikshivi@gmail.com");
        driver.findElement(By.id("fld-p1")).sendKeys("1234567890");
        driver.findElement(By.xpath("/html/body/div[1]/div/section/main/div[2]/div/div/div[1]/div/div/div/div/div/form/div[3]/button")).submit();

        String expectedTitle = "Best Buy | Official Online Store | Shop Now & Save";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Login unsuccessful");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}