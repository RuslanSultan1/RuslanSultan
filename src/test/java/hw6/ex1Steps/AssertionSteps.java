package hw6.ex1Steps;

import pageObjects.hw6.Hw6IndexPage;
import pageObjects.hw6.Hw6ServicePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class AssertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(String expectedUserName) {
        new Hw6IndexPage().checkUser(expectedUserName);
    }


    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBe(String title) {
        new Hw6IndexPage().checkTitle(title);
    }

    @And("^Interface on Home page should contain all needed elements$")
    public void interfaceOnHomePageShouldContainAllNeededElements() {
        new Hw6IndexPage().checkIndexPageInterface();
    }

    @Then("^'Service' subcategory in the header should contain options$")
    public void serviceSubcategoryInTheHeaderShouldContainOptions() {
        new Hw6IndexPage().checkHeaderServiceMenu();
    }

    @Then("^'Service' subcategory in the left section should contain options$")
    public void serviceSubcategoryInTheLeftSectionShouldContainOptions() {
        new Hw6IndexPage().checkLeftServiceMenu();
    }

    @Then("^Interface on Different elements page should contain all needed elements$")
    public void interfaceOnDifferentElementsPageShouldContainAllNeededElements() {
        new Hw6ServicePage().checkDiffElPageInterface();
    }

    @And("^There is Right Section$")
    public void thereIsRightSection() {
        new Hw6ServicePage().checkRightSection();
    }

    @And("^There is Left Section$")
    public void thereIsLeftSection() {
        new Hw6ServicePage().checkLeftSection();
    }

    @Then("^Checkbox '([^\"]*)' has value '([^\"]*)' displayed in the log row$")
    public void checkboxesWaterWindHaveValuesTrueTrueInTheLogRow(String checkbox, String status) {
        new Hw6ServicePage().checkNatureElCheckboxStatus(checkbox, status);
    }

    @Then("^Radiobutton has value '([^\"]*)' in the log row corresponded to the status$")
    public void radiobuttonHasValueInTheLogRowCorrespondedToTheStatus(String radio){
        new Hw6ServicePage().selectColorRadio(radio);
    }

    @Then("^Dropdown has value '([^\"]*)' in the log row corresponded to the selected option$")
    public void dropdownHasValueInTheLogRowCorrespondedToTheSelectedOption(String option){
        new Hw6ServicePage().checkDropdownColorStatus(option);
    }
}
