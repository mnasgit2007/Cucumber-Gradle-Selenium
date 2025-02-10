package junitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.get("https://www.saucedemo.com/");

        // Action test
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Test validation
        homePage.validateOnHomePage();
    }

    @AfterEach
    public void tearDown() {
        // Close the driver after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
