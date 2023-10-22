#Senaryo: States menusunden gelen ilk 10 verinin DB deki ile data ile ayni olup olmadigini kontrol ediniz

Feature: Testing JDBC Testing

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | states     |

    Then Send The Query the DataBase "select name from states limit 10" and control match