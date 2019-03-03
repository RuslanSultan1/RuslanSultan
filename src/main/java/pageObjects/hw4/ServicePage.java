package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class ServicePage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "select option")
    private ElementsCollection dropdownOptions;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    @Step("Checking interface on the Different elements page, if it contains all needed elements.")
    public void checkDiffElPageInterface() {
        for (SelenideElement checkbox : checkboxes) {
            checkbox.should(exist);
        }
        for (SelenideElement radio : radios) {
            radio.should(exist);
        }
        dropdown.should(exist);
        defaultButton.should(exist);
        button.should(exist);
    }

    @Step("Asserting that there is Right Section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Asserting that there is Left Section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Clicking on the checkboxes: {values}.")
    public void clickNatureElCheckbox(NatureElementsCheckboxes... values) {
        for (NatureElementsCheckboxes value : values) {
            checkboxes.find(text(value.toString())).click();
        }
    }

    @Step("Checking the {checkbox} checkbox status. It should be {status}.")
    public void checkNatureElCheckboxStatus(NatureElementsCheckboxes checkbox, Boolean status) {
        logs.find(text(checkbox.toString())).shouldHave(text(status.toString()));
    }

    @Step("Selecting {radio} radio.")
    public void selectColorRadio(MetalsOptions radio) {
        radios.find(text(radio.toString())).click();
    }

    @Step("Checking status of radio {radio}.")
    public void checkColorRadioStatus(MetalsOptions radio) {
        logs.find(text(radio.toString())).shouldBe(visible);
    }

    @Step("Selecting dropdown {dropdownOption} option.")
    public void selectDropdownColor(DropdownColorOptions dropdownOption) {
        dropdown.click();
        dropdownOptions.find(text(dropdownOption.toString())).click();
    }

    @Step("Checking dropdown status: {dropdownOption}.")
    public void checkDropdownColorStatus(DropdownColorOptions dropdownOption) {
        logs.find(text(dropdownOption.toString())).shouldBe(visible);
    }
}
