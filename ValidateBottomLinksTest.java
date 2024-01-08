package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateBottomLinksTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void validateBottomLinks() {
        List<WebElement> bottomLinks = driver.findElements(By.xpath("//footer//a"));
        
        for (WebElement link : bottomLinks) {
            String url = link.getAttribute("href");
            String linkText = link.getText();
            
            // Validate each link
            if (url != null && !url.isEmpty()) {
                driver.get(url);
                String currentUrl = driver.getCurrentUrl();
                Assert.assertNotEquals(currentUrl, "about:blank", "Link " + linkText + " is broken (about:blank)");
                Assert.assertNotEquals(currentUrl, "javascript:void(0)", "Link " + linkText + " is broken (javascript:void(0))");
                Assert.assertNotEquals(currentUrl, "about:invalid#zClosurez", "Link " + linkText + " is broken (about:invalid#zClosurez)");
            } else {
                Assert.fail("Link " + linkText + " has no URL attribute");
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}