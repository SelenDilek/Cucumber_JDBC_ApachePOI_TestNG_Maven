#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
# Eger ki sadece element yollasaydik(basliksiz) dataTable , sadece string yollasaydik scenairoExample. Bu ornekte
# element ve string yolladik. basliklarinin olmasi scenarioOutline oldugunu gosterir.
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam is2   | academicPeriod1              | gradeLevel5  |


Feature: Exam Form functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully

  Scenario Outline: Exam Functionality
    And Click on the element in LeftNav

      | entranceExams  |
      | setup2         |
      | entranceExams2 |

    And Click on the element in Dialog
      | addButon |

    #dataTable ile Scenario Outline beraber kullanildi.
    #WebElement               #String
    And User sending the keys in Dialog
      | nameInput             | <name>                  |
      | regStart              | <regStart>              |
      | regEnd                | <regEnd>                |
      | acedemicPeriyodselect | <acedemicPeriyodselect> |
      | gradeLevelSelect      | <gradeLevelSelect>      |


    And User select the academic periyod element in Dialog
    And User select the grade level element in Dialog

    And Click on the element in Dialog
      | saveButton1 |

    Then Success message should be display
    And Click on the element in LeftNav

      | entranceExams  |
      | setup2         |
      | entranceExams2 |


    And Users delete the element from Dialog
      | <name> |

    Then Success message should be display
    Examples:
      | name    | regStart   | regEnd     | acedemicPeriyodselect | gradeLevelSelect |
      | klm2212 | 11/12/2022 | 11/12/2023 | Test 2024             | 9                |
