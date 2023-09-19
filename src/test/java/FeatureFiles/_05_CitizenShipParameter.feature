#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

Feature: CitizenShip Functionality
  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario: Create a Citizenship
    When Create a Citizenship name as "slnnn" short name as "slnnn"
    Then Success message should be display

    When Create a Citizenship name as "slnnn" short name as "slnnn"
    Then Already exist message should be displayed