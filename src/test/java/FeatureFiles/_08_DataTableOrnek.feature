Feature: DataTable ornek

  Scenario: Users List
    When write usurname "selen"
    And Write usurname and Password "selen" and "1234"

    #bir parametreye coklu veri gonderme --> parameters gibi testNgdeki
    And Write usurname as DataTable
      | selen  |
      | mehmet |
      | ayse   |
      | fatma  |

    And Write usurname and Password as DataTable
      | selen  | 1234  |
      | mehmet | 23323 |
      | ayse   | 45454 |
      | fatma  | 44545 |

    #dataProvider (testNg icin) ScenarioOutline (cucumber) : gorevi verilen her deger , tum senorya calistirma
  #dataTable ise , bir stepe , çok parametre vermemizi sağlıyor