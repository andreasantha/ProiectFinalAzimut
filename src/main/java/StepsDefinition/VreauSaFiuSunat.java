package StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class VreauSaFiuSunat extends InitializareDriver {

    @Given("Open Orange webpage")
    public void open_orange_webpage() throws InterruptedException {
        InitializareDriver.getDriver().get("https://www.orange.ro/");
        sleep(3000);
        InitializareDriver.getDriver().findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        sleep(3000);
    }

    @Then("Click on Vreau sa fiu sunat button")
    public void click_on_vreau_sa_fiu_sunat_button() throws InterruptedException {
        InitializareDriver.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        // identify element
        WebElement l=InitializareDriver.getDriver().findElement(By.xpath("//a[@data-track-action='Vreau sa fiu sunat']"));
        // Actions class with moveToElement()
        Actions a = new Actions(InitializareDriver.getDriver());
        a.moveToElement(l);
        a.perform();
        InitializareDriver.getDriver().findElement(By.xpath("//a[@data-track-action='Vreau sa fiu sunat']")).click();
        sleep(3000);

    }

    @And("Introduce {string}")
    public void introduce(String phoneNumber) throws InterruptedException{
        InitializareDriver.getDriver().findElement(By.xpath("//*[@id='phoneNumberLeads']")).sendKeys(phoneNumber);
        sleep(3000);
    }

    @Then("Check GDPR chekbox")
    public void check_gdpr_chekbox() throws InterruptedException {
        InitializareDriver.getDriver().findElement(By.id("gdprCheckLeads")).click();
        sleep(3000);

    }

    @And("Click on Vreau abonament nou")
    public void click_on_vreau_abonament_nou() throws InterruptedException {
        InitializareDriver.getDriver().findElement(By.id("submitOffer")).click();
        sleep(3000);
    }


    @And("Display error message")
    public void displayErrorMessage() throws InterruptedException {
        InitializareDriver.getDriver().findElement(By.xpath("//p[@class='phoneError text-danger mb-0']")).getText();
        sleep(3000);
    }

    @Then("Display confirmation and close")
    public void displayConfirmationAndClose() throws InterruptedException {
        InitializareDriver.getDriver().findElement(By.xpath("//span[@data-track-action='Inchide 2']")).click();
        sleep(3000);
    }
}


