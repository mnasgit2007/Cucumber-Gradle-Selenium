package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BaseTest {
    WebDriver driver;

    By usernameInputText = By.cssSelector("input#user-name");
    By passwordInputText = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");

    By text_err_msg(String msg){
        return By.xpath("//*[contains(text(),'"+ msg +"')]");
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void validateErrorAppear(String errorMessage) {
        driver.findElement(text_err_msg(errorMessage)).getText();
    }
}
