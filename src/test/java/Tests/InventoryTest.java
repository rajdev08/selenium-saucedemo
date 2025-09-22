package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Tests.LoginTest;
import Pages.InventoryPage;
import jdk.jfr.Threshold;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class InventoryTest extends BaseTest
{
    @Test (priority = 1)
    public void addToCartBikeLight() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusernameLP("problem_user");
        loginpage.enterpasswordLP("secret_sauce");
        loginpage.clickLoginBtnLP();

        /*Alert alert = driver.switchTo().alert();
        alert.sendKeys(String.valueOf(Keys.ENTER));*/

        InventoryPage inventorypage = new InventoryPage(driver);
        inventorypage.clickAddCartBikeLightBtnIP();
        inventorypage.clickcartBtnIP();
    }
    /*@Test (priority = 2)
    public void removeFromCartBikeLight() {
        InventoryPage inventorypage = new InventoryPage(driver);
        inventorypage.clickRemoveCartBikeLightBtnIP();
        inventorypage.clickcartBtnIP();
    }*/
}