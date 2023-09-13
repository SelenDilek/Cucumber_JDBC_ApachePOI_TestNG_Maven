package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent { //campusun sol tarafi
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "(//span[text()='Setup'])[1]")
    public WebElement setup;

    @FindBy(css = "//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(css = "(//span[text()='Countries'])[1]")
    public WebElement countries;








}
