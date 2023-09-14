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

    When Click the close button
    When Enter citizenship'name as "<name>" and shortname as "<shortname>"
    Then Click the search button
    And Click the delete button
    Then Success message should be display

    Examples:
      | name        | shortname |
      | 022ssn1110 | 022ssn1110 |
      | 022ssn2220 | 022ssn2220 |
      | 022sne330  | 022ssn3330 |



        
        