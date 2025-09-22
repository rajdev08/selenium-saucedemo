package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    private Path tmpProfileDir;

    @BeforeMethod
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();

        // Create a unique temporary directory for Chrome profile
        tmpProfileDir = Files.createTempDirectory("selenium-profile-");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + tmpProfileDir.toString());
        options.addArguments("--incognito");                   // avoid state issues
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignore) { }
        }

        if (tmpProfileDir != null) {
            try {
                deleteDirectory(tmpProfileDir.toFile());
            } catch (Exception ignore) { }
        }
    }

    // Recursive delete helper
    private void deleteDirectory(File folder) {
        if (folder == null || !folder.exists()) return;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) deleteDirectory(f);
                else f.delete();
            }
        }
        folder.delete();
    }
}





/*package Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;


public class BaseTest
{
    protected WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    /*@AfterMethod
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
    }*/

