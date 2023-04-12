package StepsDefinition;

import io.cucumber.java.After;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitializareDriver {

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }
    public static void setup (String pageUrl) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/java/driver/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(pageUrl);
    }
    @After
    // Make sure you are using cucumber.api.java.After rather than org.junit.After
    // as Cucumber will not process JUnit annotations.
    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
