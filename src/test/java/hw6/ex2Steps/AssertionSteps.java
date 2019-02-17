package hw6.ex2Steps;

import pageObjects.hw6.Hw6UserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class AssertionSteps {

    @Then("^'([^\"]*)' page is opened$")
    public void browserTitleShouldBe(String title) {
        new Hw6UserTablePage().checkTitle(title);
    }

    @And("^6 NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayed() {
        new Hw6UserTablePage().checkDropdowns();
    }

    @And("^6 User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayed() {
        new Hw6UserTablePage().checkNames();
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(){
        new Hw6UserTablePage().checkImages();
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayed(){
        new Hw6UserTablePage().checkImages();
    }

    @And("^6 checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayed(){
        new Hw6UserTablePage().checkCheckboxes();
    }

    @And("^User table contains following values$")
    public void userTableContainsFollowingValues(){
        new Hw6UserTablePage().checkUserTable();
    }

    @Then("^1 log row has '([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(String status){
        new Hw6UserTablePage().checkVIPCheckboxStatus(status);
    }

    @Then("^Droplist contains values$")
    public void droplistContainsValues() {
        new Hw6UserTablePage().checkDropdownOptions();
    }
}
