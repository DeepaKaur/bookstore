#Author: Deepa Kaur
  #Keywords Summary : Book store page
@BookStore
Feature: Book store page

  Scenario: Testing book store to navigate to book details page without user logged in
    Given A user navigates to book store website
    When User clicks "Git Pocket Guide" link from table
    Then Book details page for "Git Pocket Guide" is displayed

#
#  Scenario: Testing book store to add book to collection
#    Given A user is on book store login page
#    And User logs in with credentials
#      | Username | Password |
#      |abc123| Abc1234#|
#    And User clicks on Book Store from side nav
#    And User clicks 'Git Pocket Guide' link from books table
#    When User clicks add to collection button
#    Then Success message popup is displayed
#    And Book is added to the collection
