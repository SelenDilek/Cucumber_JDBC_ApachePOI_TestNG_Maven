package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//campusun sag tarafi
public class DialogContent extends Parent { //extend Parent yaptik cunku Dialog Content onlari icersin ve Dialog Contentten
    //nesne urettigimiz zaman (LoginSteps'de) taniyor.
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement usurname;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;


    @FindBy(css = "span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;

    //not: sag tarafta buttonlar ortak her sayfa icin ortak bir locator bulacaz.(tum sayafalar icin ortak locatorler bulcaz)
    //mesela country , states,cities sayfalari icin.
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButon;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code' ]//input")
    public WebElement codeInput;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname,'shortName')]//input")
    public WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'Citizenship successfully created')]")
    public WebElement successMessagecitizenship;

    @FindBy(xpath = "//dynamic-view[@class='ng-star-inserted']//div")
    public WebElement alreadyMsg;
//The Citizenship with Name "sln123" already exists.

    //(//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base'])[2]

    @FindBy(xpath = "(//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base ng-star-inserted'])")
    public WebElement maximizeButton;

    @FindBy(xpath = "(//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base'])[2]")
    public WebElement closeButton;

    @FindBy(xpath = "(//button[@class='mdc-button mat-mdc-button mat-accent mat-flat-button mat-mdc-button-base'])")
    public WebElement searchButton;

    @FindBy(xpath = "(//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-warn mat-mdc-button-base ng-star-inserted'])[1]")
    public WebElement deleteButton;
}
