package junitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSeleniumTest {

    @Test
    public void loginTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
    }
}
