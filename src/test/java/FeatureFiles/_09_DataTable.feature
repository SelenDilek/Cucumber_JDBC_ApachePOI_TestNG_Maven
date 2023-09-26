Feature: DataTable Functionality
  Background:
    Given Navigate to campus
    When Enter usurname and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the element in Dialog
      | addButon |
    #bunlar elementlerim ama string suan (pages daki web element isimleri ile ayni olmali cunku isimden yakalayacam ve table seklinde gonderecem)
  #bunlar tekli fakat send text yaparken locator ve text oldugu icin 2 boyutlu gondeririz stringlerimizi.(yazi gonderecegiz)

    #biri web element digeri string
    And User sending the keys in Dialog
      | nameInput | enUlk1a  |
      | codeInput | enUlk11a |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be display

    #delete icin String gonderiyoruz. DataTable da String mi yoksa Web Element mi gonderiyoruz dikkat edilmeli.
    And Users delete the element from Dialog
      | enUlk1a |

    Then Success message should be display

  Scenario:  Create Nationality
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButon |

    And User sending the keys in Dialog
      | nameInput | anls54 |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be display

    And Users delete the element from Dialog
      | ismnls54Nat1 |

    Then Success message should be display

  Scenario: Fee Functionality
    And Click on the element in LeftNav

      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButon |

    And User sending the keys in Dialog
      | nameInput       | annlsn54 |
      | codeInput       | annlns5  |
      | integrationCode | anlns   |
      | priorty         | a23699  |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be display

    And Users delete the element from Dialog
      | annlsn54 |

    Then Success message should be display

    #senerio outline ile bir senerio yu 5 kez calistirabilirim.


