package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;


import java.time.Duration;

public class _05_CitizienShipParameter {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a Citizenship")
    public void createACitizenship() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShCo = RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput, citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShCo);
        dc.myClick(dc.saveButton);
    }

    @When("Create a Citizenship name as {string} short name as {string}")
    public void createACitizenshipNameAsShortNameAs(String name, String shortname) {
        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.shortName, shortname);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyMsg, "already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String name) {

        dc.deleteItem(name); //alti yoruma daha sonra aldik cunku her sayfada ortak bu.
//        dc.mySendKeys(dc.searchInput, name);
//        dc.myClick(dc.searchButton);
//        //not kapatma tusu yerine esc ye de basmayi codlayabiliriz.
//
//       //1.YONTEM :
//        //stale element hatasi cikti : ben elemani buldum.tam tiklayacakti bu eleman buldugum eleman degil
//        //oldugunu gordum yani element bayatlamis yani bu o degil.(tez buldum,cabuk kaybettim) buluyor hizlica ve sayfa yenileniyor tam tiklayacak
//        //elementi tanimiyor buldugum bu degil diyor.(ilk buldugu element kaybolmus) cozum:bu sayfanin yenilenmesini bekle ondan sonra bul.
//        //sayfanin yenilenmesini bekle --> stale element icin kullanilir. search button a tikladik tekrar tiklanabilir olana kadar bekle.
//        //ikinci yolu ust tarafta bir cizgi var mavi serit gibi loading oluyor
//        //wait.until(ExpectedConditions.stalenessOf(dc.searchButton)); //boyle de yapabilirdik ama hep ise yaramiyor cunku gecisleri beklemeleri
//        //bazen yakalayamiyor.
//        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.searchButton));
//
//
//        //2.YONTEM:sayfanin kendi waitini,loadigini yakalayalim.(developerin kodu ile en saglam yol)
//        //cocuklarindan tumunden(/*)  sifir olana kadar bekle yani progress bar i goremiyoruz ama nerde oldugunu bulduk.
//        //fuse-progress-bar/*    -> fuse-progress-bar ın çocukları
//        // bu çocukların 0 olana bekle
//
//        dc.wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));
//        dc.myClick(dc.deleteImageBtn);
//        dc.myClick(dc.deleteDialogBtn);
    }

}

