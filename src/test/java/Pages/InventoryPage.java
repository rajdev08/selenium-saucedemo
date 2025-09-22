package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;


    public By addCartBikeLightBtnIP = By.id("add-to-cart-sauce-labs-bike-light");
    public By removeCartBikeLightBtnIP = By.id("remove-sauce-labs-bike-light");
    public By cartBtnIP = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddCartBikeLightBtnIP()
    {
        driver.findElement(addCartBikeLightBtnIP).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-bike-light")));
        System.out.print("Bike Light added to the cart");
    }

    public void clickRemoveCartBikeLightBtnIP()
    {
        driver.findElement(removeCartBikeLightBtnIP).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-bike-light")));
        System.out.print("Bike Light removed from the cart");
    }

    public void clickcartBtnIP() {
        driver.findElement(cartBtnIP).click();
    }
}
