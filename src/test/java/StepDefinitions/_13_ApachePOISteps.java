package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _13_ApachePOISteps {
    //excele bilgileri yazdir ve sil (yaptigin islemlerin sonucunu excele yaz diye interview da soruyorlar.)
    DialogContent dc = new DialogContent();
    @When("User create citizenship with ApahcePOI")
    public void userCreateCitizenshipWithApahcePOI() {
        //excelden getData ile oku bilgiyi ve sonra bir for dongusu ile kaydet

ArrayList<ArrayList<String>> tablo=ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for(ArrayList<String> satir : tablo){

            dc.myClick(dc.addButon);
            dc.mySendKeys(dc.nameInput,satir.get(0));
            dc.mySendKeys(dc.shortName,satir.get(1));
            dc.myClick(dc.saveButton);
            dc.verifyContainsText(dc.successMessage,"success");
        }

    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        //excelden oku bilgiyi getData ile bir dongu ile hepsini sil (yukariyi aynen al ve sil)

 ArrayList<ArrayList<String>> tablo =ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for(ArrayList<String> satir : tablo){

            dc.deleteItem(satir.get(0));
            dc.verifyContainsText(dc.successMessage,"success");
        }


    }
}
