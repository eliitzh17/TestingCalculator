Feature: Math

  Scenario: 1. Plus
    When User send equation "2+3"
    Then Results should be 5

  Scenario: 2. Minus
    When User send equation "10-2"
    Then Results should be 8

  Scenario: 3. Order of operations
    When User send equation "(10-2)*2"
    Then Results shouldn't be 20

  Scenario: 4. sin
    When User send equation "sin(30)"
    Then Results should be 0.5

  Scenario: 5. Validate history
    Then Validate equation history:
      | equation | results |
      | 2+3      | 5       |
      | 10-2     | 8       |
      | (10-2)*2 | 16      |
      | sin(30)  | 0.5     |