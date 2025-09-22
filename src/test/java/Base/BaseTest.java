package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    private String tmpProfileDir;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        tmpProfileDir = System.getProperty("java.io.tmpdir") + File.separator + "selenium-profile-" + System.currentTimeMillis();
        options.addArguments("user-data-dir=" + tmpProfileDir);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble"); // prevents save-password bubble
        options.addArguments("--disable-popup-blocking");       // don't block test popups, but mostly harmless
        options.addArguments("--incognito");                    // incognito helps avoid existing profile state

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
                File dir = new File(tmpProfileDir);
                deleteDirectory(dir);
            } catch (Exception ignore) { }
        }
    }

    // simple recursive delete helper
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

