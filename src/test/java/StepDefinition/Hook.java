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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jose_\\OneDrive\\Escritorio\\Proyecto\\ejemploGherkinLint\\src\\test\\java\\Runner\\LocalChromeRunner\\chromedriver.exe");
         driver = new ChromeDriver();

         /*
        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserstack.user","josesandoval_p9o8dE");
        options.setCapability("browserstack.key","A6ZSzk6CqF1fonuJvZqY");
        options.setCapability("os_version", "10");
        options.setCapability("browser", "chrome");

        driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), options);
*/
        driver.manage().window().maximize();
    }

    @After
    public static void quitDriver(){
        if(driver!=null){
            driver.close();
        }
    }
}
