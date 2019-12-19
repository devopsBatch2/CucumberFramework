Feature: Testing AWS Calculator

  @TECTC-110
  Scenario: Testing calculation og prices for EC2 instances

    Given user Navigate to AWS Calculator Homepage
    When User adds 2 EC2 Instances
    And user adds 2 EC2 Deducated costs
    Then Total estimated cost has to match with prices on "testData" "Sheet2" excel file