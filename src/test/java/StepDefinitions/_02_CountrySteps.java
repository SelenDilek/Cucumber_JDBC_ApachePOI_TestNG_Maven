package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();


    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.countries);


    }

    @When("Create country")
    public void createCountry() {
        //bazen ayni ad cikiyor hata cikiyor o yuzden generic hale getiriyoruz.
        //apache commons ekleyecez random string uretsin diye pom a. --> fake veri uretiyor.
        String ulkeAdi=RandomStringUtils.randomAlphanumeric(8);//8 harf
        String ulkeKodu= RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,ulkeAdi);
        dc.mySendKeys(dc.codeInput,ulkeKodu);
        dc.myClick(dc.saveButton);

    }

    @Then("Success message should be display")
    public void successMessageShouldBeDisplay() {
        dc.verifyContainsText(dc.successMessage,"success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {

        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.codeInput,code);
        dc.myClick(dc.saveButton);
    }
}
