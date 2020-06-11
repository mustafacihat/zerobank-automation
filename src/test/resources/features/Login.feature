@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page


  Scenario:login with  valid credentials
    When the user log in with "username" "password"
    Then the user should be able to login

  Scenario Outline:login with invalid credentials username :<username> password: <password>
    When the user try to login "<username>" "<password>"
    Then the user should not be able to login

    Examples:
      | username | password |
      | user     | pass     |
      |          | 12345    |
      | johnWade |          |
      |          |          |
@wip
  Scenario: logout
    When the user log in with "username" "password"
    Then the user should be able to login
    And the user should be able to logout succesfully
