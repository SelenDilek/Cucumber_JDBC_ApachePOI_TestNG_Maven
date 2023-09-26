package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import javax.xml.crypto.Data;
import java.util.List;

public class _08_DataTableOrnek {
    @When("write usurname {string}")
    public void writeUsurname(String userName) {
        System.out.println("userName = " + userName);
    }

    @And("Write usurname and Password {string} and {string}")
    public void writeUsurnameAndPasswordAnd(String userName, String password) {
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
    }

    @And("Write usurname as DataTable")
    public void writeUsurnameAsDataTable(DataTable userlar) { //ben bunlari DataTable formtinda aliyorum.yani string turu.
       List<String> listUserlar =userlar.asList(String.class);
       for(String user : listUserlar){

           System.out.println("user = " + user);
       }
    }

    @And("Write usurname and Password as DataTable")
    public void writeUsurnameAndPasswordAsDataTable(DataTable kullaniciveSifreler) {

        //listelerin listesi
        List<List<String>> listKullaniciveSifreler = kullaniciveSifreler.asLists(String.class); //s geldi

        for (int i = 0; i <listKullaniciveSifreler.size() ; i++) {

            System.out.println("ListItemleri = " + listKullaniciveSifreler.get(i).get(0) + " " //username
                                                  + listKullaniciveSifreler.get(i).get(1));    //password


            //i. satirin sifirinci elemani i.satirin 1. elemani

        }



    }






    }

