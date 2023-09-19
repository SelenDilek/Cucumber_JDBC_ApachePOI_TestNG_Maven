Feature: DataTable Functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | citizenship  |
    #bunlar elementlerim ama string suan (pages daki web element isimleri ile ayni olmali cunku isimden yakalayacam ve table seklinde gonderecem)