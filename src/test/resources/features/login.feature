#Author: Deepa Kaur
  #Keywords Summary : Login page
@Login
Feature: Book store application login page

  Scenario: Testing missing username on login page
    Given A user is on book store login page
    When User does not populate 'username' and submits
      | username | password |
      |          | Kaur    |
    Then Input error for username is displayed

  Scenario: Testing missing password on login page
    Given A user is on book store login page
    When User does not populate 'password' and submits
      | username | password |
      |       abc   |     |
    Then Input error for password is displayed

  Scenario: Testing valid login
    Given A user is on book store login page
    When User enters login credentials and submits
      | Username | Password |
      |abc123| Abc1234#|
    Then User successfully logs in
    And Username is displayed
      | Username |
      |abc123|
    And User logs out




