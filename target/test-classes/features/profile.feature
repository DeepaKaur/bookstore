#Author: Deepa Kaur
  #Keywords Summary : Profile page
@Profile
Feature: Profile page

  Scenario Outline: Testing profile page
    Given A user is on book store page
    When User enters <username> and <password> and submits
    Then User successfully logs in
    And <username> is displayed
    And User clicks profile from side nav
    Then Profile page is displayed
    And User logs out

    Examples:
      |username|password|
      |"abcd"    |"Abcd1234!"|



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
