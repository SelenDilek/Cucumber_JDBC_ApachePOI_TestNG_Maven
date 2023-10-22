package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import Utilities.GWDold;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

// @FindBy(xpath = "//*[@class='mdc-data-tablecontent']//td[@class='mat-mdc-cell mdc-data-tablecell cdk-cell cdk-column-name mat-column-name ng-tns-c1331969616-187 ng-star-inserted']")
// //tbody[@role='rowgroup']//tr//td[2]
// [class*='cdk-cell cdk-column-name mat-column-name']
public class _14_JDBCSteps {
    DialogContent dc=new DialogContent();
    @Then("Send The Query the DataBase {string} and control match")
    public void sendTheQueryTheDataBaseAndControlMatch(String sql) {

        // DB den oku
        List< List<String> > dbList= DBUtility.getDataList(sql); // db den okudum

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println( dbList.get(i).get(0));  // okuduğum DB bilgisini kontrol ediyorum(iki boyutlu listeye tek boyut attik)
        }

        System.out.println("-------------------------");

        // UI dan oku
        List<WebElement> UIList = dc.nameList;
        for (int i = 0; i < UIList.size() ; i++) {
            System.out.println(UIList.get(i).getText()); // okuduğum UI bilgisini kontorl ediyorum
        }

        // karşılaştır.
        for (int i = 0; i < dbList.size(); i++) { //dbList ile UIList size ayni birini yazdik
            System.out.println( dbList.get(i).get(0)+"- "+UIList.get(i).getText());
            Assert.assertEquals( dbList.get(i).get(0).trim(), UIList.get(i).getText().trim(),"Eşleştirme yapılamadı");
            //Assert.assertEquals( dbList.get(i).get(0).trim(), dc.nameList.get(i).getText().trim(),"Eşleştirme yapılamadı");
            //bu kisa cozumu
        }
    }
}
