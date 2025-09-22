package org.JavaChallenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Googletest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager automatically downloads the correct driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyGoogleTitle() {
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Google", "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
