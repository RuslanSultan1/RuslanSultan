Feature: Service Page Test

  Scenario: Testing service page interface
    Given I open EPAM JDI site
    # TODO It will be better to split this step
    # TODO It will be better if  you pass here entire User (class or enum)
    When I login as User 'PITER_CHAILOVSKII'
    Then Browser title should be 'INDEX_PAGE_TITLE'
    # TODO Same like comment on line 6
    And User name should be 'PITER_CHAILOVSKII'
    And Home page contains all needed elements: 4 pictures, 4 texts under them, 2 texts above
    # TODO Parameter ?
    When I click on 'SERVICE' subcategory in the header
    Then 'Service' subcategory in the header should contain options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | USER_TABLE         |
      | TABLES_WITH_PAGES  |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I click on 'SERVICE' subcategory in the left section
    Then 'Service' subcategory in the left section should contain options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | USER_TABLE         |
      | TABLES_WITH_PAGES  |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I open through the header menu Service -> 'DIFFERENT_ELEMENTS'
    # !TODO
    Then Different elements page contains all needed elements:4 checkboxes, 4 radios, 1 dropdown, 2 buttons
    And There is Right Section
    And There is Left Section
    When I select checkboxes:
      | WATER |
      | WIND  |
    Then Checkbox 'WATER' has value 'true' displayed in the log row
    And Checkbox 'WIND' has value 'true' displayed in the log row
    When I select radio 'SELEN'
    Then Radiobutton has value 'SELEN' in the log row corresponded to the status
    When I select in dropdown 'YELLOW'
    Then Dropdown has value 'YELLOW' in the log row corresponded to the selected option
    When I unselect checkboxes:
      | WATER |
      | WIND  |
    Then Checkbox 'WATER' has value 'false' displayed in the log row
    And Checkbox 'WIND' has value 'false' displayed in the log row