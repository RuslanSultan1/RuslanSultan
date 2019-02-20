Feature: User Table Page Test

  # TODO Take a look on HomeTask carefully, you have to copy scenario as it is
  # TODO Most all of this steps should be parametrised
  Scenario: Testing user table page interface
    Given I am on 'Home Page'
    And I login as user 'PITER_CHAILOVSKII'
    When I click on 'SERVICE' button in Header
    And I click on 'USER_TABLE' button in Service dropdown
    Then 'USER_TABLE' page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    # TODO List of values should be here
    And User table contains following values:
      | Number | User             | Desciption                       |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'Roman'
    # TODO List of values should be here as well
    Then Droplist contains values:
      | Admin   |
      | User    |
      | Manager |

