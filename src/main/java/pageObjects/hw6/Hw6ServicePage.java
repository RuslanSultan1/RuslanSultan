package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickNatureElCheckbox(String... values) {
        for (String value : values) {
            checkboxes.find(text(value)).click();
        }
    }

    public void checkNatureElCheckboxStatus(String checkbox, String status) {
        logs.find(text(checkbox)).should(visible,text(status));
    }

    public void selectColorRadio(String radio) {
        radios.find(text(radio)).click();
    }

    public void checkColorRadioStatus(String radio) {
        logs.find(text(radio)).shouldBe(visible);
    }

    public void selectDropdownColor(String dropdownOption) {
        dropdown.click();
        dropdownOptions.find(text(dropdownOption)).click();
    }

    public void checkDropdownColorStatus(String dropdownOption) {
        logs.find(text(dropdownOption)).shouldBe(visible);
    }
}
