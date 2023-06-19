package Page;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

import static org.awaitility.Awaitility.await;

public class BasePage {

    private static final int WAIT_TIMEOUT= 90;
    private static final int WAIT_SLEEP= 100;
    final WebDriver DRIVER;
    private final WebDriverWait WAIT;

    protected BasePage(WebDriver driver) {
        this.DRIVER = driver;
        this.WAIT = new WebDriverWait(driver, WAIT_TIMEOUT,WAIT_SLEEP);
        //buscar porque se utiliza ajaxelementLocator y no otro locator
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,WAIT_TIMEOUT), this);
    }

    public boolean isVisible(WebElement element){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException | StaleElementReferenceException e){
            return false;
        }
    }

    public void waitElementIsVisible(WebElement element){
        try {
            await().atMost(WAIT_TIMEOUT,SECONDS).until(()->isVisible(element));
        }
        catch (ConditionTimeoutException e){
            new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 90 Segundos",element));
        }

    }

    public void waitElementIsVisibleTimeOut(WebElement element,int waitTimeOut){
        try {
            await().atMost(waitTimeOut,SECONDS).until(()->isVisible(element));
        }
        catch (ConditionTimeoutException e){
            new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 90 Segundos",element));
        }

    }
}
