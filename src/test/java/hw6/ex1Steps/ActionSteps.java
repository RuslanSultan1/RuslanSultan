package hw6.ex1Steps;

import cucumber.api.java.en.And;
import enums.*;
import pageObjects.hw6.Hw6ServicePage;
import cucumber.api.java.en.When;

import java.util.List;

import static hw6.ex1Steps.NavigationSteps.indexPage;

public class ActionSteps {
    static Hw6ServicePage servicePage;

    @And("^I login as User '([^\"]*)'$")
    public void iLoginAsUser(User user) {
        indexPage.login(user);
    }

    @When("^I click on '([^\"]*)' subcategory in the header$")
    public void iClickOnSubcategoryInTheHeader(HeaderSection page) {
        indexPage.clickHeaderButton(page);
    }

    @When("^I click on '([^\"]*)' subcategory in the left section$")
    public void iClickOnSubcategoryInTheLeftSection(HeaderSection page) {
        indexPage.clickLeftButton(page);
    }

    @When("^I open through the header menu Service -> '([^\"]*)'$")
    public void iOpenThroughTheHeaderMenuServiceDifferentElementsPage(ServiceMenu page) {
        indexPage.openPage(page);
        servicePage = new Hw6ServicePage();
    }

    @When("^I select checkboxes:")
    public void iSelectCheckboxes(List<NatureElementsCheckboxes> checkboxes) {
        servicePage.clickNatureElCheckbox(checkboxes);
    }

    @When("^I select radio '([^\"]*)'$")
    public void iSelectRadio(MetalsOptions radio) {
        servicePage.selectColorRadio(radio);
    }

    @When("^I select in dropdown '([^\"]*)'$")
    public void iSelectInDropdown(DropdownColorOptions option) {
        servicePage.selectDropdownColor(option);
    }

    @When("^I unselect checkboxes:")
    public void iUnselectCheckboxes(List<NatureElementsCheckboxes> checkboxes) {
        servicePage.clickNatureElCheckbox(checkboxes);
    }
}
