package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.*;
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

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void clickNatureElCheckbox(NatureElementsCheckboxes... values) {
        for (NatureElementsCheckboxes value : values) {
            checkboxes.find(text(value.toString())).click();
        }
    }

    public void checkNatureElCheckboxStatus(NatureElementsCheckboxes checkbox, Boolean status) {
        logs.find(text(checkbox.toString())).shouldHave(text(status.toString()));
    }

    public void selectColorRadio(ColorRadios radio) {
        radios.find(text(radio.toString())).click();
    }

    public void checkColorRadioStatus(ColorRadios radio) {
        logs.find(text(radio.toString())).shouldBe(visible);
    }

    public void selectDropdownColor(DropdownColorOptions dropdownOption) {
        dropdown.click();
        dropdownOptions.find(text(dropdownOption.toString())).click();
    }

    public void checkDropdownColorStatus(DropdownColorOptions dropdownOption) {
        logs.find(text(dropdownOption.toString())).shouldBe(visible);
    }


}
