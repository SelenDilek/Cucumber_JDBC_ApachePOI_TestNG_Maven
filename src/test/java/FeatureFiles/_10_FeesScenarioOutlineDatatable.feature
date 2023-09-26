#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.
#dataTable(string ve element ) ve ScenerioOutline(string) beraber kullandik (birden cok veri icin birden cok test islemi yapildi)
Feature: Fees multiple values functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
    #bunlar buton ve web element ilk donusturecez sonra tiklayacaz datatable ile.
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButon |

    #element ve string gonderecem dataTable icinde  scnerio outline kullandik.
    And User sending the keys in Dialog
      | nameInput       | <name>    |
      | codeInput       | <code>    |
      | integrationCode | <intCode> |
      | priorty         | <priorty> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be display

    #bu kisim webelement degil sadece text gonderiyoruz donusturme yok.
    And Users delete the element from Dialog
      | <name> |

    Then Success message should be display
    Examples:
      | name   | code   | intCode | priorty |
      | test1a | code1a | Cash    | 123a    |
      | test2a | code2a | Credit  | 321a    |
      | test3a | code3a | PayPal  | 456a    |

    #senerio outline ile bir senerio yu 5 kez calistirabilirim.