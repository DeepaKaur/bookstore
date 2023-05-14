#Author: Deepa Kaur
  #Keywords Summary : Profile page
@Profile
Feature: Profile page

  Scenario: Testing profile page
    Given A user is on book store page
    When User enters login credentials and submits
      | Username | Password |
      |abc123| Abc1234#|
    Then User successfully logs in
    And User clicks profile from side nav
    Then Profile page is displayed
    And User logs out

#  Scenario: Testing books in collection
#    Given A user is on profile page
#    Then Verify ‘bookname’ book is present in collections
#      |bookname|
#      |Git Pocket Guide|
#
#  Scenario: Delete books in collection
#    Given A user is on profile page
#    When User clicks delete all books button
#    And verifies popup message to delete
#    Then Confirmation popup message is displayed
#    And All books are deleted from collection
