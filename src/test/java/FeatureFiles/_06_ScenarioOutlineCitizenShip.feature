#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız

Feature: CitizenShip Functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
    And Navigate to citizenship

    #dataProvider gibi (birden cok test yapmak icin lazim. TestNg gibi.)
  Scenario Outline: Create a Citizenship
    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Success message should be display

    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    Examples:
      | name       | shortname  |
      | ssslnnn1aa | ssslnnn1aa |
      | ssslnnn2aa | ssslnnn2aa |
      | ssslnnn3aa | ssslnnn3aa |
      | ssslnnn4aa | ssslnnn4aa |
      | ssslnnn5aa | ssslnnn5aa |


