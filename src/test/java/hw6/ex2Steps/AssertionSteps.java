package hw6.ex2Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.ServiceMenu;

import java.util.List;

import static hw6.ex2Steps.ActionSteps.userTablePage;

// TODO It is not make sense to create new PO in each step, take a look on cucumber hooks
public class AssertionSteps {

    @Then("^'([^\"]*)' page is opened$")
    public void browserTitleShouldBe(ServiceMenu title) {
        userTablePage.checkTitle(title);
    }

    @And("^6 NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayed() {
        userTablePage.checkDropdowns();
    }

    @And("^6 User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayed() {
        userTablePage.checkNames();
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.checkImages();
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayed() {
        userTablePage.checkDescriptionsTexts();
    }

    @And("^6 checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayed() {
        userTablePage.checkCheckboxes();
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<String> values) {
        userTablePage.checkUserTable(values);
    }

    @Then("^1 log row has '([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(String status) {
        userTablePage.checkVIPCheckboxStatus(status);
    }

    @Then("^Droplist contains values:$")
    public void droplistContainsValues(List<String> userTypes) {
        userTablePage.checkDropdownOptions(userTypes);
    }
}
