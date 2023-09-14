package StepDefinitions;
import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
public class _05_CitizienShipParameter {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a Citizenship")
    public void createACitizenship() {
        String citizenshipName= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShCo= RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShCo);
        dc.myClick(dc.saveButton);
    }

    @When("Create a Citizenship name as {string} short name as {string}")
    public void createACitizenshipNameAsShortNameAs(String name, String shortname) {
        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortName, shortname);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyMsg, "already");
    }


}
