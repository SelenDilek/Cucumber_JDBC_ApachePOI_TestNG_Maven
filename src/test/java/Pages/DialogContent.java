package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'NAME')]//input[@data-placeholder='Name']")
    public WebElement searchInput;
    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteDialogBtn;


    // silme ıslemı dıalogların ortak noktası olması sebebıyle buraya aldık.
    // Silme islemi yapacagımız her seferınde tekrar tekrar kod yazmayalım dırekt cagıralım dıye aldık.
    public void deleteItem(String searchText) {
        //bir sey tekrar ediyorsa onu ait olan yerde fonksiyon haline getir.
        //burasi dialoglarin ortak noktasi parentte left nav ait kisimlar da var bu dialoglara ait olan kisimlar.
        mySendKeys(searchInput, searchText);
        myClick(searchButton);
        //not kapatma tusu yerine esc ye de basmayi codlayabiliriz.

        //1.YONTEM :
        //stale element hatasi cikti : ben elemani buldum.tam tiklayacakti bu eleman buldugum eleman degil
        //oldugunu gordum yani element bayatlamis yani bu o degil.(tez buldum,cabuk kaybettim) buluyor hizlica ve sayfa yenileniyor tam tiklayacak
        //elementi tanimiyor buldugum bu degil diyor.(ilk buldugu element kaybolmus) cozum:bu sayfanin yenilenmesini bekle ondan sonra bul.
        //sayfanin yenilenmesini bekle --> stale element icin kullanilir. search button a tikladik tekrar tiklanabilir olana kadar bekle.
        //ikinci yolu ust tarafta bir cizgi var mavi serit gibi loading oluyor
        //wait.until(ExpectedConditions.stalenessOf(dc.searchButton)); //boyle de yapabilirdik ama hep ise yaramiyor cunku gecisleri beklemeleri
        //bazen yakalayamiyor.
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));


        //2.YONTEM:sayfanin kendi waitini,loadigini yakalayalim.(developerin kodu ile en saglam yol)
        //cocuklarindan tumunden(/*)  sifir olana kadar bekle yani progress bar i goremiyoruz ama nerde oldugunu bulduk.
        //fuse-progress-bar/*    -> fuse-progress-bar ın çocukları
        // bu çocukların 0 olana bekle

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        myClick(deleteImageBtn);
        myClick(deleteDialogBtn);
    }


    public WebElement getWebEelement(String strElement) {

        //return oldugu icin break koymaya gerek yok zaten direkt gidiyor. geri donuyor cikiyor donguden.

        switch (strElement) {

            case "usurname":
                return this.usurname;
            case "password":
                return this.password;
            case "loginButton":
                return this.loginButton;
            case "txtTechnoStudy":
                return this.txtTechnoStudy;
            case "addButon":
                return this.addButon;
            case "nameInput":
                return this.nameInput;
            case "codeInput":
                return this.codeInput;
            case "saveButton":
                return this.saveButton;
            case "successMessage":
                return this.successMessage;
            case "shortName":
                return this.shortName;
            case "successMessagecitizenship":
                return this.successMessagecitizenship;
            case "alreadyMsg":
                return this.alreadyMsg;
            case "searchInput":
                return this.searchInput;
            case "searchButton":
                return this.searchButton;
            case "deleteImageBtn":
                return this.deleteImageBtn;
            case "deleteDialogBtn":
                return this.deleteDialogBtn;

        }


        return null; // eger ki bir sey gelmezse donus olarak null gonder.


    }
}