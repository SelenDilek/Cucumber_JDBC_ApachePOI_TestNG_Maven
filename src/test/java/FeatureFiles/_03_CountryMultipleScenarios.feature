Feature: Country Multi Scenario

  Background: #before scenario gibi once bu sonra senerio1 once bu sonra senerio2
    Given Navigate to campus
    When  Enter usurname and password and click login button
    Then  User should login successfully
    And  Navigate to country

  @Regression #taglar konusu icin ekledim. En son ders
  Scenario: Create country
    When Create country
    Then Success message should be display

  @Regression
  Scenario: Create country 2
    When Create a country name as "nUerr110" code as "err110"
              #ilk burayi calistirdik ve sadece bu adimi when olani yazdik country icine
    Then Success message should be display
  #daha once yazdigim fonksiyonu methodu git calistir.(otomatik cikan yazilar icin)

        #diger featurelarda yer alan adimlari aynen yazdigimizda onlari calistirir tekrar step def icine method olarak
  #yazdirmaz. sadece yeni adimi istedigin stepdef icine yazdirir.