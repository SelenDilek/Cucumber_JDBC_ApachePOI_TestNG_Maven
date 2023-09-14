#Senaryo
#Citizenships sayfasına gidiniz.
#1 adet Citizenships kaydı yapılabildiğini doğrulayınız.

Feature: CitizenShip Functionality
  Scenario: CitizenShip registration
    Given Navigate to campus
    When  Enter usurname and password and click login button
    Then  User should login successfully
    And  Navigate to citizenship
    When Create a citizenship
    Then Success message should be display