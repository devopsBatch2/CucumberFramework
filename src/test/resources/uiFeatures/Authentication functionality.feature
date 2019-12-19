@UserStory-1
Feature:  Authentication functionality

#  Background: Common first steps
#    Given Navigate to login page

  Scenario: Create an account verify it is created by signing in (Use Datatable)
    Given Navigate to web page
    Then Navigate to sign in button
    And User logs in with valid email "tec@gmail.com" and creates an account
    Then User enters his Personal Information
      | Title | First name | Last name | Email       | Password | First name | Last name | Company    | Address        | City    | State    | Country       | Zip/Postal Code | Mobile phone | Assign an address alias for future reference. |
      | Mrs   | Gylia      | Samatova  | tec@gmail.com | ggggg    | Gylia      | Samatova  | Techtorial | 1234 W Main st | Chicago | Illinois | United States | 60666           | 123456789z   | hello hello hello                             |
    And Verify if the account is created by signing in

  Scenario: Sign in  with valid credentials
    Then Navigate to sign in button
    And User signs in with valid credentials email "tec@gmail.com" and password "ggggg"

      And Verify user is in Homepage
  Scenario: Sign in  with invalid credentials
    Then Navigate to sign in button
    And User signs in with valid credentials email "t@gmail.com" and password "sssss"
    And Verify user gets error message "Invalid Login or Password."