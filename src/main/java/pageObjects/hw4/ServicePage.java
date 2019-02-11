package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import enums.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class ServicePage {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radios;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "select option")
    private List<SelenideElement> dropdownOptions;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs>li")
    private List<SelenideElement> logs;

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

    public void selectCheckbox(Checkboxes checkbox) {
        checkboxes.get(checkbox.ordinal()).click();
        System.out.println(checkboxes.get(checkbox.ordinal()).isSelected());
    }

    public void unselectCheckbox(Checkboxes checkbox) {
        checkboxes.get(checkbox.ordinal()).click();
    }

    public void checkCheckboxStatus(Checkboxes checkbox, Boolean status) {
        logs.get(0).shouldHave(text(checkbox.toString()));
        logs.get(0).shouldHave(text(status.toString()));
    }

    public void selectRadio(Radios radio) {
        radios.get(radio.ordinal()).click();
    }

    public void checkRadioStatus(Radios radio) {
        logs.get(0).shouldHave(text(radio.toString()));
    }

    public void selectDropdown(DropdownOptions dropdownOption) {
        dropdown.click();
        dropdownOptions.get(dropdownOption.ordinal()).click();
    }

    public void checkDropdownStatus(DropdownOptions dropdownOption) {
        logs.get(0).shouldHave(text(dropdownOption.toString()));
    }


}
