package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest
{
    @Test (priority = 1)
    public void validLogin()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusernameLP("problem_user");
        loginpage.enterpasswordLP("secret_sauce");
        loginpage.clickLoginBtnLP();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Login failed - check Username and Password");
    }

   /* @Test
    public void InvalidLogin()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusernameLP("noproblem_user");
        loginpage.enterpasswordLP("secret_sauce");
        loginpage.clickLoginBtnLP();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"),"Login successful - put wrong creds");
    } */

}
