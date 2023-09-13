#Login kontrol senaryosu
  #siteye git
  #login bilgilerini gir
  #giris yaptigini dogrula
  #asagidaki yazilar kahverengi sonradan beyaz oluyor cunku step def.e eklememizi istiyor.

Feature: Login functionality
  Scenario: Login with valid usurname and password
    Given Navigate to campus
    When  Enter usurname and password and click login button
    Then User should login successfully



