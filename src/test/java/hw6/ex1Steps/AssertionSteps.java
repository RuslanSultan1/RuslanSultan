package hw6.ex1Steps;

import enums.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static hw6.ex1Steps.NavigationSteps.indexPage;
import static hw6.ex1Steps.ActionSteps.servicePage;

public class AssertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(User expectedUser) {
        indexPage.checkUserName(expectedUser);
    }


    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBe(LoginInfo title) {
        indexPage.checkTitle(title);
    }

    @And("^Home page contains all needed elements: 4 pictures, 4 texts under them, 2 texts above$")
    public void HomePageContainsAllNeededElements() {
        indexPage.checkIndexPageInterface();
    }

    @Then("^'Service' subcategory in the header should contain options:$")
    public void serviceSubcategoryInTheHeaderShouldContainOptions(List<ServiceMenu> values) {
        indexPage.checkHeaderServiceMenu(values);
    }

    @Then("^'Service' subcategory in the left section should contain options:$")
    public void serviceSubcategoryInTheLeftSectionShouldContainOptions(List<ServiceMenu> values) {
        indexPage.checkLeftServiceMenu(values);
    }

    @Then("^Different elements page contains all needed elements:4 checkboxes, 4 radios, 1 dropdown, 2 buttons$")
    public void DifferentElementsPageContainsAllNeededElements() {
        servicePage.checkDiffElPageInterface();
    }

    @And("^There is Right Section$")
    public void thereIsRightSection() {
        servicePage.checkRightSection();
    }

    @And("^There is Left Section$")
    public void thereIsLeftSection() {
        servicePage.checkLeftSection();
    }

    @Then("^Checkbox '([^\"]*)' has value '([^\"]*)' displayed in the log row$")
    public void checkboxesWaterWindHaveValuesTrueTrueInTheLogRow(NatureElementsCheckboxes checkbox, String status) {
        servicePage.checkNatureElCheckboxStatus(checkbox, status);
    }

    @Then("^Radiobutton has value '([^\"]*)' in the log row corresponded to the status$")
    public void radiobuttonHasValueInTheLogRowCorrespondedToTheStatus(ColorRadios radio) {
        servicePage.checkColorRadioStatus(radio);
    }

    @Then("^Dropdown has value '([^\"]*)' in the log row corresponded to the selected option$")
    public void dropdownHasValueInTheLogRowCorrespondedToTheSelectedOption(String option) {
        servicePage.checkDropdownColorStatus(option);
    }
}
