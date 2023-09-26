package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {

    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
//linkler elementler , liste ceviririz. Gelen veriler string oldugu icin list ici string

        List<String> strlinkList = linkler.asList(String.class);
        //listin ici string tipinde web element tipinde degil.
//not sirali gitmesi icin bunun fori olmasi lazim o yuzden yorum satirina aliyoruz fori yapiyoruz
        for (int i = 0; i <strlinkList.size() ; i++) {

            WebElement linkWebElement= ln.getWebEelement(strlinkList.get(i));
            ln.myClick(linkWebElement);

        }


//        for (String strLink : strLinkler){
//            System.out.println("strLink = " + strLink);
//
//            ln.myClick(ln.getWebEelement(strLink));
//
//          //not boyle de yapabilirdik stringi web elemente cevirebiliriz.
//            //WebElement link = ln.getWebEelement(strLink);
//        }
        //Stringleri web elemente cevirmem lazim. Stringi bir fonk gonder web elementi gelsin.
        //mesela setup kelimesine dc.setup elementini gonder bana diyebileyim.LeftNav e gideriz.

            //not boyle de yapabilirdik stringi web elemente cevirebiliriz.
            //WebElement link = ln.getWebEelement(strLink);
        }


        //dataTable ile element gonderme islemi yaptik. (string geliyor convert ediyoruz.)
    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable buttons) { //dialog daki her sey button veya text
        //datatable,liste,fori,elemente cevir,click
        List<String> strButtonList = buttons.asList(String.class);
        for (int i = 0; i <strButtonList.size() ; i++) {

            WebElement linkWebElement = dc.getWebEelement(strButtonList.get(i));
            dc.myClick(linkWebElement);

        }
    }
    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dt) {

        List<List<String>> items = dt.asLists(String.class); //s geldi //listelerin listesi

        for (int i = 0; i <items.size() ; i++) {
            WebElement e = dc.getWebEelement(items.get(i).get(0));

            dc.mySendKeys(e,items.get(i).get(1)); //ikinci element webelement degil yazi o yuzden direkt gonderdim.
            //1.yazisi
        }
    }
    @And("Users delete the element from Dialog")
    public void usersDeleteTheElementFromDialog(DataTable dt) {

        List<String> silinecekler = dt.asList(String.class);
        for (int i = 0; i <silinecekler.size() ; i++) {

            //WebElement linkWebElement = dc.getWebEelement(silinecekler.get(i)); (Webelement haline getirmemize gerek yok)
            //zaten text yazi gonderip siliyorum . String.
            dc.deleteItem(silinecekler.get(i));

        }
    }
}


