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

    Scenario Outline: Create a Citizenship
      When Create a Citizenship name as "<name>" short name as "<shortname>"
      Then Success message should be display

      When Create a Citizenship name as "<name>" short name as "<shortname>"
      Then Already exist message should be displayed

      Examples:
        | name | shortname |
        | ssslnnn1a | ssslnnn1a |
        | ssslnnn2a | ssslnnn2a |
        | ssslnnn3a | ssslnnn3a |
        | ssslnnn4a | ssslnnn4a |
        | ssslnnn5a | ssslnnn5a |


