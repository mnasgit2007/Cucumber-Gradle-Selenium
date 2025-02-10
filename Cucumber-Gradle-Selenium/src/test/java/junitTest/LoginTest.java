package junitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {

    @Test
    public void loginTest(){
        // inisialisasi webdriver
        // WebDriver driver = WebDriverManager.chromedriver().create();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // inisialisasi page object
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        // action test
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // test validation
        homePage.validateOnHomePage();

    }
}
