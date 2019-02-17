Feature: User Table Page Test

  Scenario: Testing user table page interface
    Given I am on 'Home Page'
    And I login as user 'PITER_CHAILOVSKII'
    When I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    And User table contains following values
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'Roman'
    Then Droplist contains values
