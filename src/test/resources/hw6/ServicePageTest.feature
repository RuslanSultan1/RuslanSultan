Feature: Service Page Test

  Scenario: Testing service page interface
    Given I open EPAM JDI site
    When I login to 'Home Page' as user 'epam' with password '1234'
    Then Browser title should be 'Home Page'
    And User name should be 'PITER CHAILOVSKII'
    And Interface on Home page should contain all needed elements
    When I click on 'Service' subcategory in the header
    Then 'Service' subcategory in the header should contain options
    When I click on 'Service' subcategory in the left section
    Then 'Service' subcategory in the left section should contain options
    When I open through the header menu Service -> Different Elements Page
    Then Interface on Different elements page should contain all needed elements
    And There is Right Section
    And There is Left Section
    When I select checkboxes: 'Water', 'Wind'
    Then Checkbox 'Water' has value 'true' displayed in the log row
    And Checkbox 'Wind' has value 'true' displayed in the log row
    When I select radio 'Selen'
    Then Radiobutton has value 'Selen' in the log row corresponded to the status
    When I select in dropdown 'Yellow'
    Then Dropdown has value 'Yellow' in the log row corresponded to the selected option
    When I unselect checkboxes: 'Water', 'Wind'
    Then Checkbox 'Water' has value 'false' displayed in the log row
    And Checkbox 'Wind' has value 'false' displayed in the log row




