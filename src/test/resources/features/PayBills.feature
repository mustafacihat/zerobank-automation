@payBills
Feature: Pay Bills Page

  Background:
    Given the user logged in homepage
    And the user should be in Pay Bills Page

  Scenario: Verify the page title
    Then the title should be "Zero - Pay Bills"

  Scenario Outline:  Pay operation <amount> <date> <description>
    Then the user should be able to complete pay operation succesfully with "<amount>" "<date>" "<description>"

    Examples:
      | amount | date       | description   |
      | 100    | 2020-06-22 | to my brother |

  @wip
  Scenario Outline: Try to make a payment without entering the amount or the date <amount> <date>
    Then the user should receive an message "<amount>" "<date>"

    Examples:
      | amount | date       |
      |        | 2020-05-10 |
      | 500    |            |
      |        |            |

  Scenario Outline: Try to make a payment with invalid characters <amount> <date>
    Then the system not allow to enter invalid characters "<amount>" "<date>"

    Examples:
      | amount      | date       |
      | aLleTTer%&% | oo-pp-ll   |
      | 47eee7aeau  | 20aa-0k-12 |
      | ueegiu      | ueueu-eueue |