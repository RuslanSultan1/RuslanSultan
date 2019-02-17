package hw6.ex1Steps;

import pageObjects.hw6.Hw6IndexPage;
import pageObjects.hw6.Hw6ServicePage;
import cucumber.api.java.en.When;

public class ActionSteps {

    @When("^I login to 'Home Page' as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAsUserWithPassword(String username, String password) {
        new Hw6IndexPage().login(username, password);
    }

    @When("^I click on 'Service' subcategory in the header$")
    public void iClickOnServiceSubcategoryInTheHeader() {
        new Hw6IndexPage().cliclHeaderServiceButton();
    }

    @When("^I click on 'Service' subcategory in the left section$")
    public void iClickOnServiceSubcategoryInTheLeftSection() {
        new Hw6IndexPage().clickLeftServiceButton();
    }

    @When("^I open through the header menu Service -> Different Elements Page$")
    public void iOpenThroughTheHeaderMenuServiceDifferentElementsPage() {
        new Hw6IndexPage().openDiffElPage();
    }

    @When("^I select checkboxes: *'([^\"]*)', *'([^\"]*)'$")
    public void iSelectCheckboxes(String checkbox1, String checkbox2){
            new Hw6ServicePage().clickNatureElCheckbox(checkbox1,checkbox2);
        }

    @When("^I select radio '([^\"]*)'$")
    public void iSelectRadio(String radio){
        new Hw6ServicePage().selectColorRadio(radio);
    }

    @When("^I select in dropdown '([^\"]*)'$")
    public void iSelectInDropdown(String option){
        new Hw6ServicePage().selectDropdownColor(option);
    }

    @When("^I unselect checkboxes: '([^\"]*)', '([^\"]*)'$")
    public void iUnselectCheckboxes(String checkbox1, String checkbox2){
        new Hw6ServicePage().clickNatureElCheckbox(checkbox1,checkbox2);
    }
}
