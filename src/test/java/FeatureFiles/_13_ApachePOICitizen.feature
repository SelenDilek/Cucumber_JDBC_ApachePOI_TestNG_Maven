#Excelden okudugunuz Citizenship bilgilerini onceden hepsini kaydedin daha sonra silin.
Feature: ApachePOI Citizen Functionality
  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
    And Navigate to citizenship

    Scenario: Create and Delete CitizenShip from excel
      When  User create citizenship with ApahcePOI
      Then  User delete citizenship with ApachePOI