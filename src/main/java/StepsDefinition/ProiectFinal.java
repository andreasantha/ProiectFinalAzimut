package StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ProiectFinal {

    @Given("Open Orange webpage")
    public void open_orange_webpage() throws InterruptedException {
        WebDriverInitialize.startBrowser("https://www.orange.ro/");
        sleep(3000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        sleep(3000);
    }
    @Then("Click on Vreau sa fiu sunat button")
    public void click_on_vreau_sa_fiu_sunat_button() throws InterruptedException {
        WebDriverInitialize.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        // identify element
        WebElement l=WebDriverInitialize.getDriver().findElement(By.xpath("//a[@data-track-action='Vreau sa fiu sunat']"));
        // Actions class with moveToElement()
        Actions a = new Actions(WebDriverInitialize.getDriver());
        a.moveToElement(l);
        a.perform();
        WebDriverInitialize.getDriver().findElement(By.xpath("//a[@data-track-action='Vreau sa fiu sunat']")).click();
        sleep(3000);
    }
    @And("Introduce {string}")
    public void introduce(String phoneNumber) throws InterruptedException{
        WebDriverInitialize.getDriver().findElement(By.id("phoneNumberLeads")).sendKeys(phoneNumber);
        sleep(3000);
    }
    @Then("Check GDPR chekbox")
    public void check_gdpr_chekbox() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.id("gdprCheckLeads")).click();
        sleep(3000);
    }
    @And("Click on {string}")
    public void click(String button) throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.id("submitOffer")).click();
        sleep(3000);
    }
    @Then("Display confirmation and close")
    public void displayConfirmationAndClose() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//span[@data-track-action='Inchide 2']")).click();
        sleep(3000);
    }

    //Link Catre Social Media
    @Then("Click on {string} Icon")
    public void clickOnIcon(String nameIcon) throws InterruptedException{
        switch(nameIcon) {

            case "Facebook"-> {
                WebDriverInitialize.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                // identify element
                WebElement l=WebDriverInitialize.getDriver().findElement(By.xpath("//*[@href='https://www.facebook.com/orangeromania']"));
                // Actions class with moveToElement()
                Actions a = new Actions(WebDriverInitialize.getDriver());
                a.moveToElement(l);
                a.perform();
                sleep(3000);
                WebDriverInitialize.getDriver().findElement(By.xpath("//*[@href='https://www.facebook.com/orangeromania']")).click();
                sleep(3000);
            }

            case "Twitter" -> {
                WebDriverInitialize.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                // identify element
                WebElement l=WebDriverInitialize.getDriver().findElement(By.xpath("//*[@href='https://twitter.com/orangeromania']"));
                // Actions class with moveToElement()
                Actions a = new Actions(WebDriverInitialize.getDriver());
                a.moveToElement(l);
                a.perform();
                sleep(3000);
                WebDriverInitialize.getDriver().findElement(By.xpath("//*[@href='https://twitter.com/orangeromania']")).click();
                sleep(3000);
            }
            case "Youtube"->{
                WebDriverInitialize.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                // identify element
                WebElement l=WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='youtube']"));
                // Actions class with moveToElement()
                Actions a = new Actions(WebDriverInitialize.getDriver());
                a.moveToElement(l);
                a.perform();
                sleep(3000);
                WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='youtube']")).click();
                sleep(3000);
            }
            case "Instagram"-> {
                WebDriverInitialize.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                // identify element
                WebElement l=WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='instagram']"));
                // Actions class with moveToElement()
                Actions a = new Actions(WebDriverInitialize.getDriver());
                a.moveToElement(l);
                a.perform();
                sleep(3000);
                WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='instagram']")).click();
                sleep(3000);
            }
            default -> {
                WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='"+nameIcon+"']")).click();              sleep(3000);
            }
        }
    }
    @And("Close Opened Tab")
    public void closeOpenedTab() throws InterruptedException{
        String tabPrincipal = WebDriverInitialize.getDriver().getWindowHandle();
        for (String windowhandle : WebDriverInitialize.getDriver().getWindowHandles()) {
            if (!tabPrincipal.contentEquals(windowhandle)) {
                WebDriverInitialize.getDriver().switchTo().window(windowhandle);
                System.out.println(WebDriverInitialize.getDriver().getCurrentUrl());
                WebDriverInitialize.getDriver().close();
            }
        }
        sleep(3000);
        WebDriverInitialize.getDriver().switchTo().window(tabPrincipal);
    }

    //Login To My account
    @Then("Click on My account button")
    public void click_on_my_account_button() throws InterruptedException{
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='My_Account']")).click();
        sleep(3000);
    }
    @Then("Enter {string} adress")
    public void enter_email_adress(String emailAdress) throws InterruptedException{
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='login']")).sendKeys(emailAdress);
        sleep(3000);
    }
    @Then("Enter {string}")
    public void enter_password(String passWord) throws InterruptedException{
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(passWord);
        sleep(3000);
    }
    @Then("Click the {string} button")
    public void clickTheButton(String button) throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//button[@id='loginBtn']")).click();
        sleep(3000);
    }
    @And("Verify message is {string}")
    public void verifyMessageIs(String confirmationMessage) throws InterruptedException {
        Assert.assertEquals(WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='phoneError text-danger mb-0']")).getText(), confirmationMessage);
    sleep(3000);
    }

    @Then("Verify message {string}")
    public void verifyMessage(String errorMessage) throws InterruptedException {
        Assert.assertEquals(WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='field-validation-error error-message']")).getText(),errorMessage);
        sleep(3000);
    }

    @Then("Verify the message {string}")
    public void verifyTheMessage(String confMessage) throws InterruptedException{
        Assert.assertEquals(WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='requiredError passwordError']")).getText(),confMessage);
        sleep(3000);
    }
}


