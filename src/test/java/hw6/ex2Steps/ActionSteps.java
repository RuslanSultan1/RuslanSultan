package hw6.ex2Steps;

import enums.HeaderSection;
import enums.ServiceMenu;
import pageObjects.hw6.Hw6UserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static hw6.ex2Steps.NavigationSteps.indexPage;

public class ActionSteps {
    static Hw6UserTablePage userTablePage;

    @When("^I click on '([^\"]*)' button in Header$")
    public void iClickOnButtonInHeader(HeaderSection page) {
        indexPage.clickHeaderButton(page);
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iOpenPage(ServiceMenu page) {
        indexPage.openPage1(page);
        userTablePage=new Hw6UserTablePage();
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckbox(String name) {
        userTablePage.clickVIPCheckboxByName(name);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnDropdown(String name) {
        userTablePage.clickDropdownByName(name);
    }
}
