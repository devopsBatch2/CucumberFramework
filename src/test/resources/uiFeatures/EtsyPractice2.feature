 @User-Story2
Feature: Etsy page

  Scenario:Search functionality
    Given Navigate to "https://www.etsy.com/"
    When Search "wallet"
    Then Verify the result

