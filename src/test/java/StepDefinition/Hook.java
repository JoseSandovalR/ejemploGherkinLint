package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    public static WebDriver driver;
    public static final String USERNAME = "josesandoval_p9o8dE";
    public static final String AUTOMATE_KEY = "A6ZSzk6CqF1fonuJvZqY";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

    @Before
    public static void createDriver() throws MalformedURLException {

        /*
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath = "";

        if (os.contains("win")) {
            driverPath = "src/test/java/Runner/LocalChromeRunner/windows/chromedriver.exe";
        } else if (os.contains("nux") || os.contains("nix")) {
            driverPath = "/src/test/java/Runner/LocalChromeRunner/linux/chromedriver";
        } else if (os.contains("mac")) {
            driverPath = "/src/test/java/Runner/LocalChromeRunner/chromedriver.exe";
        } else {
            throw new IllegalStateException("Your OS is not supported!!");
        }

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

         */


        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserstack.user","josesandoval_p9o8dE");
        options.setCapability("browserstack.key","A6ZSzk6CqF1fonuJvZqY");
        options.setCapability("os_version", "10");
        options.setCapability("browser", "chrome");

        driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), options);

        driver.manage().window().maximize();
    }

    @After
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
