Feature: Project Data base with Excel Sheet
@jdbs_111
  Scenario:Testing Euorope Employees with validating UI information

    Given Navigate  to the DataBase
    When Get first_name and last_name  of employees who works in Europe validate with their UI information (First name, Last Name)
    Then  go to Excel "TestData" "Sheet3" and update column 'Actual # of Employees' with number of Europe employees that you get from UI.
    Then Compare ‘Actual # of Employees’’ with ‘expected # of Employees’
    And if they matched then update ‘Test Execution Status’ cell as "PASSED" if not match then update with "FAILED".

@jdbs_112
  Scenario: Testing Department Name and number of ‘Active’employeesand validate with their UI numbers.

    Given User go to the Database
    When get Department Nameand number of "Active"employeesand validate with their UI numbers.
    Then go to Excel "TestData" "Sheet3"and update column 'Actual # of Employees' with number of Activememployees that you get from UI
    And compare that number with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as "PASSED" if not match then update with "FAILED".