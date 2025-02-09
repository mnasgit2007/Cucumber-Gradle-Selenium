package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    static String generateRandomEmail() {
        String allowedChart = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); // panjang email 10 karakter
        email = temp + "@testdata.com";
        return email;
    }

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

        public static void quitDriver(){
        driver.quit();
}
