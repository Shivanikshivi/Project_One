package com.test.project;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;


public class BestBuyOne {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      
    }
    
    @Test(priority = 1)
    public void verifyBestBuyURL() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://www.bestbuy.com/").openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("URL is valid");
            } else {
                System.out.println("URL is broken");
            }
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