package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
//Ben testNG değilim onun kadar Annotation yok
//çünkü ihtiyacım yok, ihtiyaç kısmını testNG den
//kullanırım. sadece bana lazım olan kısım
//Senaryo bitti veya başladı Annotation ı.
//
//2 tane Annotation
//After
//Before
    @Before
    public void before(){

        System.out.println("Senorya basladi : ?");

    }

    @After
    public void after(){

        System.out.println("Senorya bitti : ?");
        //dogru calisirsa burada quiti cagiracam.

        GWD.quitDriver();
    }

}
