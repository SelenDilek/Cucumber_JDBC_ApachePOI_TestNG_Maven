package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent { //campusun sol tarafi
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setup;

    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countries;

    @FindBy(xpath = "//span[text()='Citizenships']")
    public WebElement citizenship;

    @FindBy(xpath = "//span[text()='Nationalities']")
    public WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    public WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    public WebElement entranceExams;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement entranceExams2;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    public WebElement setup2;

    @FindBy(xpath="(//*[text()='States'])[1]")
    public WebElement states;
    //Entrance Exams
    //DataTable icin ben buraya kelime halini yani string yollayacam geriye bana web element gonderecek.

    public WebElement getWebEelement(String strElement) {

        //return oldugu icin break koymaya gerek yok zaten direkt gidiyor. geri donuyor cikiyor donguden.

        switch (strElement) {

            case "setup":
                return this.setup;
            case "parameters":
                return this.parameters;
            case "countries":
                return this.countries;
            case "citizenship":
                return this.citizenship;
            case "nationalities":
                return this.nationalities;
            case "fees":
                return this.fees;
            case "entranceExams":
                return this.entranceExams;
            case "entranceExams2":
                return this.entranceExams2;
            case "setup2":
                return this.setup2;
            case "states":
                return this.states;

        }


        return null; // eger ki bir sey gelmezse donus olarak null gonder.


    }


}
