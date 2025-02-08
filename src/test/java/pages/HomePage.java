package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BaseTest {

    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateOnHomePage(){
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }
}
