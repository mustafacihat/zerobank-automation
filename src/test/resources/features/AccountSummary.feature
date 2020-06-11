@accountSummary
Feature: Account Summary page

  Background:
    Given the user logged in homepage

  Scenario: Verify the page title
    Then the title should be "Zero - Account Summary"

  Scenario: Verify account types of Account Summary Page
    Then Account Summary Page has these account types
@smoke
  Scenario: Verify the columns of Credit Accounts table
    Then Credit Accounts table should have Account, Credit Card and Balance





