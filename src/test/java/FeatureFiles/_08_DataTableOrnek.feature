Feature: DataTable ornek

  Scenario: Users List
    When write usurname "selen"
    And Write usurname and Password "selen" and "1234"

    #bir parametreye coklu veri gonderme --> parameters gibi testNgdeki
    And Write usurname as DataTable
      | selenn  |
      | mehmetn |
      | aysen   |
      | fatman  |

    And Write usurname and Password as DataTable
      | selenn  | 1234n  |
      | mehmetn | 23323n |
      | aysen   | 45454n |
      | fatman  | 44545n |

    #dataProvider (testNg icin) ScenarioOutline (cucumber) : gorevi verilen her deger , tum senorya calistirma
  #dataTable ise , bir stepe , çok parametre vermemizi sağlıyor