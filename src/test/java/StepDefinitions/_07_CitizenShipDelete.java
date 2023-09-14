package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _07_CitizenShipDelete {
    DialogContent dc = new DialogContent();
    LeftNav ln= new LeftNav();
    @When("Click the close button")
    public void clickTheCloseButton() {
        dc.myClick(dc.maximizeButton);
        dc.myClick(dc.closeButton);

    }

    @When("Enter citizenship'name as {string} and shortname as {string}")
    public void enterCitizenshipNameAsAndShortnameAs(String name, String shortname) {
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortName,shortname);


    }

    @Then("Click the search button")
    public void clickTheSearchButton() {
        dc.myClick(dc.searchButton);
    }

    @And("Click the delete button")
    public void clickTheDeleteButton() {
        dc.myClick(dc.deleteButton);
    }
}
