package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
   public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20)); //public olmazsa diger paketlerden erisim olmaz.
    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//        bir butona tıklatacağın zaman hangi aşamalar lazım
//        wait clickable
//        scrollunu yap
//        click
    }

    public void mySendKeys(WebElement element , String yazi){
        wait.until(ExpectedConditions.visibilityOf(element));
        //scroll yap
        scrollToElement(element);
        element.clear();
        element.sendKeys(yazi);
//        bir textbox ın sağlıklı çalışması için hangi aşamalar lazım
//        visible olana kadar bekle
//        scrollunu yap
//        clear yap
//        yazıyı gönder



    }

    public  void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }

    public  void verifyContainsText(WebElement element,String value){

        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        //action la ESC ye basarak acik kutu veya mesaj var ise kapat.
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform(); //bu kismi delete islemi yaparken cikan mesaj kutusunu kapatip isleme
        //devam etmek icin kullandik. basari ile olusturdu yazisindan sonraki islemde ekranda kaliyor kutu.

    }


}
