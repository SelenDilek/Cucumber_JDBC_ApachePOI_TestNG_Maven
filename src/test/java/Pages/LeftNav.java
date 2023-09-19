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

    //DataTable icin ben buraya kelime halini yani string yollayacam geriye bana web element gonderecek.

    public WebElement getWebEelement(String strElement){

        //return oldugu icin break koymaya gerek yok zaten direkt gidiyor. geri donuyor cikiyor donguden.

        switch (strElement){

            case "setup" : return this.setup;
            case "parameters" : return this.setup;
            case "countries" : return this.setup;
            case "citizenship" : return this.setup;

        }


        return null ; // eger ki bir sey gelmezse donus olarak null gonder.


    }










}
