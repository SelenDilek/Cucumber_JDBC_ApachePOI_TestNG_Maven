package StepDefinitions;
import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;

import java.time.Duration;

public class _01_LoginSteps {

    DialogContent dc = new DialogContent(); //dc nesnesi sayesinde hem dialogContent e hem de Parent e ulasabildim.
    //cunku parent i DialogContent e extends ettik. (methodlari ve elementleri bir arada kullanabiliyoruz.)

    @Given("Navigate to campus")
    public void navigate_to_campus() {

        GWD.getDriver().get("https://test.mersys.io/");//benim driver a ihtiyacim var.
       // System.out.println("Site acildi");
    }

    @When("Enter usurname and password and click login button")
    public void enter_usurname_and_password_and_click_login_button() {
        //System.out.println("Username ve password girildi");

        //WebDriverWait wait = new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOf());
        //dc.usurname.sendKeys("turkeyts");//gunumuz diyorki sen developrden once git BDD bu demek.Developerlik bir seyyoksuan
        //dc.password.sendKeys("TechnoStudy123");
        //dc.loginButton.click();

        dc.mySendKeys(dc.usurname, "turkeyts");
        dc.mySendKeys(dc.password, "TechnoStudy123");
        dc.myClick(dc.loginButton);



    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
       // System.out.println("girildigi test edildi");
        //sisteme girdigimi nasil anlarim? Assertion ile.
        dc.verifyContainsText(dc.txtTechnoStudy,"Techno Study");

    }





















}
