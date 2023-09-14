package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
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

    }


}
