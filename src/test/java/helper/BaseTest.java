package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    protected void getDriver(){
        // Mengatur ChromeDriver menggunakan WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        // Membuat objek ChromeDriver
        driver = new ChromeDriver(options);

        // Mengatur timeout implisit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
