package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.MetalsOptions;
import enums.DropdownColorOptions;
import enums.NatureElementsCheckboxes;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class Hw6ServicePage {

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

    public Hw6ServicePage() {
        page(this);
    }

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

    public void clickNatureElCheckbox(List<NatureElementsCheckboxes> values) {
        for (NatureElementsCheckboxes value : values) {
            checkboxes.find(text(value.toString())).click();
        }
    }

    public void checkNatureElCheckboxStatus(NatureElementsCheckboxes checkbox, String status) {
        logs.find(text(checkbox.toString())).should(visible, text(status));
    }

    public void selectColorRadio(MetalsOptions radio) {
        radios.find(text(radio.toString())).click();
    }

    public void checkColorRadioStatus(MetalsOptions radio) {
        logs.find(text(radio.toString())).shouldBe(visible);
    }

    public void selectDropdownColor(DropdownColorOptions dropdownOption) {
        dropdown.click();
        dropdownOptions.find(text(dropdownOption.toString())).click();
    }

    public void checkDropdownColorStatus(String dropdownOption) {
        logs.find(text(dropdownOption)).shouldBe(visible);
    }
}
