#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#oluşturulan her CitizenShip i siliniz. 
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız

Feature: CitizenShip Functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario Outline: Delete a Citizenship
    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Success message should be display

    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    #bu adimi _05_CitizenShip class icine olustrduk orayla baglantili
    When User delete the "<name>"
    Then Success message should be display

    Examples:
      | name  | shortname |
      | k012ksss | k012ksss|


#esc,stale element, loading (numberofchield) , parentta public wait , delete komutu ise her yerde ortak parent e aldik.silme islemi




        
        