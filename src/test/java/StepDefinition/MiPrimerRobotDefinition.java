package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import Page.MiPrimerRobotPage;
import org.openqa.selenium.WebDriver;

public class MiPrimerRobotDefinition {

    MiPrimerRobotPage miPrimerRobotPage;
    WebDriver driver;
    public MiPrimerRobotDefinition() {
         miPrimerRobotPage = new MiPrimerRobotPage(Hook.driver);
    }

    @When("algo")
    public void algo(){
        System.out.println("paso por aqui");
    }

    @Given("Ingreso al portal mi demo")
    public void ingresoAlPortalMiDemo() {
        MiPrimerRobotPage miPrimerRobotPage = new MiPrimerRobotPage(Hook.driver);
        Hook.driver.get("https://demo.automationtesting.in/Register.html");
        Assert.assertTrue("akjisa",true);
    }

    @When("se verifican elementos del home")
    public void seVerificanElementosDelHome() {
        Assert.assertTrue("No se encuentra el elemento Primer Nombre",miPrimerRobotPage.isvisiblePrimerNombre());
        miPrimerRobotPage.sendkeysTextArea("algoooooooooooooo");
        miPrimerRobotPage.clickRadioButtonMale();
    }
}
