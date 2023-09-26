#Senaryo :
#  //mat-option[@role='option']//span Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam Form functionality

  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully
@Regression
  Scenario Outline: Exam Functionality
    And Click on the element in LeftNav

      | entranceExams  |
      | setup2         |
      | entranceExams2 |

    And Click on the element in Dialog
      | addButon |

    And User sending the keys in Dialog
      | nameInput | <name>     |
      | regStart  | <regStart> |
      | regEnd    | <regEnd>   |

    And Click on the element in Dialog
      | acedemicPeriyod  |
      | acedemicPeriyodselect |
      | gradeLevel      |
      | gradeLevelSelect     |

    And User select the academic periyod element in Dialog
    And User select the grade level element in Dialog

    And Click on the element in Dialog
      | saveButton1 |

    Then Success message should be display

    And Click on the element in LeftNav

      | entranceExams  |
      | setup2         |
      | entranceExams2 |

    And Click on the element in Dialog
      | searchAcademicPeriod  |
      | acedemicPeriyodselect |


    And Users delete the element from Dialog
      | <name> |

    Examples:
      | name    | regStart   | regEnd     |
      | klmm11122 | 11/10/2022 | 11/10/2023 |

