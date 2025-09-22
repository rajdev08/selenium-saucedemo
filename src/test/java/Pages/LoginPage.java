package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;

    public By usernameLP = By.id("user-name");
    public By passwordLP = By.id("password");
    public By loginButtonLP = By.id("login-button");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void enterusernameLP(String username)
    {
        driver.findElement(usernameLP).sendKeys(username);
    }

    public void enterpasswordLP(String password)
    {
        driver.findElement(passwordLP).sendKeys(password);
    }
    public void clickLoginBtnLP()
    {
        driver.findElement(loginButtonLP).click();
    }
}
