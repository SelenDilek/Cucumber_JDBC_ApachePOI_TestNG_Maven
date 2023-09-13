Feature: Country Functionality
  Scenario: Create a country
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
    And Navigate to country
    When Create country
    Then Success message should be display