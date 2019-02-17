package hw6.ex2Steps;

import pageObjects.hw6.Hw6IndexPage;
import pageObjects.hw6.Hw6UserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ActionSteps {

    @When("^I click on 'Service' button in Header$")
    public void iClickOnServiceButtonInHeader() {
        new Hw6IndexPage().cliclHeaderServiceButton();
    }

    @And("^I click on 'User Table' button in Service dropdown$")
    public void iOpenOnUserTablePage() {
        new Hw6IndexPage().openUserTablePage();
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckbox(String name) {
        new Hw6UserTablePage().clickVIPCheckboxByName(name);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnDropdown(String name) {
        new Hw6UserTablePage().clickDropdownByName(name);
    }
}
