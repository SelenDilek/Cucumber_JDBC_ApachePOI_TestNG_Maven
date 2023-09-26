package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class _11_EntranceExam {
    DialogContent dc = new DialogContent();


    @And("User select the academic periyod element in Dialog")
    public void userSelectTheAcademicPeriyodElementInDialog() throws InterruptedException {
        dc.myClick(dc.acedemicPeriyod);

        for(WebElement item : dc.acedemicPeriyodselect){
            dc.wait.until(ExpectedConditions.elementToBeClickable(item));
            System.out.println("item.getText() = " + item.getText());

        }

        dc.wait.until(ExpectedConditions.visibilityOf(dc.acedemicPeriyodselect.get(2)));

        dc.myClick(dc.acedemicPeriyodselect.get(2));
    }
    @And("User select the grade level element in Dialog")
    public void userSelectTheGradeLevelElementInDialog() throws InterruptedException {

        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.gradeLevel));
        dc.myClick(dc.gradeLevel);

        for(WebElement i : dc.gradeLevelSelect){
            dc.wait.until(ExpectedConditions.elementToBeClickable(i));
            System.out.println("item.getText() = " + i.getText());

        }
        dc.wait.until(ExpectedConditions.visibilityOf(dc.gradeLevelSelect.get(2)));

        dc.myClick(dc.gradeLevelSelect.get(2));


    }

    @And("Users click the delete button")
    public void usersClickTheDeleteButton() {
        dc.myClick(dc.deleteButton);
        dc.myClick(dc.deleteButton2);

    }
}
