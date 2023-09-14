package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.Select;

public class _04_CitizenShipSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to citizenship")
    public void navigateToCitizenship() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a citizenship")
    public void createCitizenship() {
        String citizenshipName= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShortCode= RandomStringUtils.randomNumeric(4); // 4 rakam
        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,citizenshipName);
        dc.mySendKeys(dc.shortName,citizenshipShortCode);
        dc.myClick(dc.saveButton);
        dc.verifyContainsText(dc.successMessagecitizenship,"successfully");

    }


}
