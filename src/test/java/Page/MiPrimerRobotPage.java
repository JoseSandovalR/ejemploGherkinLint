package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiPrimerRobotPage extends BasePage {

    public MiPrimerRobotPage(WebDriver driver) {
        super(driver);
    }

    //xpath correcto
    @FindBy(xpath = "//label[contains(text(),'Full Name*')]")
    //xpath incorrecto
   // @FindBy(xpath = "//label[contains(text(),'noooooooo')]")
    private WebElement labelFullName;

    @FindBy(xpath = "//textarea[@ng-model='Adress' and @rows='3']")
    private WebElement textArea;

    @FindBy(xpath = "//input[@type='radio' and @value='Male']")
    private WebElement radioButtonMale;

    public void sendkeysTextArea(String texto){
        waitElementIsVisible(textArea);
        textArea.sendKeys(texto);
    }

    public void getTextPrimerNombre(){
        waitElementIsVisible(labelFullName);
        labelFullName.getText();
    }

    public void clickRadioButtonMale(){
        waitElementIsVisible(radioButtonMale);
        radioButtonMale.click();
    }

    public boolean isvisiblePrimerNombre(){
        waitElementIsVisibleTimeOut(labelFullName,10);
        return labelFullName.isDisplayed();
    }
}
