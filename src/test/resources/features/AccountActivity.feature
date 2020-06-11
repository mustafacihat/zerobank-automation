@accountActivity
Feature: Account Activity Page

  Background:
    Given the user logged in homepage
    And the user should be in Account Activity Page

  Scenario: Verify the page title
    Then the title should be "Zero - Account Activity"

  Scenario: Verify the default option
    Then the default option should be Savings

  Scenario: Verify the options
    Then the options should be Savings, Checking, Loan, Credit Card, Brokerage

  Scenario: Verify the columns of Transactions table
    Then Transactions table should have Date, Description, Deposit, Withdrawal


