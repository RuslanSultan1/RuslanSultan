package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.TypeDropdown;
import enums.UserTable;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static enums.UserTable.getUserByName;
import static org.testng.Assert.assertEquals;

public class Hw6UserTablePage {

    public Hw6UserTablePage() {
        page(this);
    }

    @FindBy(css = "select")
    private ElementsCollection dropdowns;

    @FindBy(css = "td [href]")
    private ElementsCollection names;

    @FindBy(css = "td img")
    private ElementsCollection images;

    @FindBy(css = ".user-descr")
    private ElementsCollection descriptions;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "tr>td:nth-of-type(4n-3)")
    private ElementsCollection numbers;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    @FindBy(css="tr:nth-of-type(2) option")
    private  ElementsCollection dropdownOptions;

    public void checkTitle(String UserTablePageTitle) {
        assertEquals(title(), UserTablePageTitle);
    }

    public void checkDropdowns() {
        for (SelenideElement dropdown : dropdowns) {
            dropdown.shouldBe(visible);
        }
    }

    public void checkNames() {
        for (UserTable user : UserTable.values()) {
            names.find(text(user.getName())).shouldBe(visible);
        }
    }

    public void checkImages() {
        for (SelenideElement image : images) {
            image.shouldBe(visible);
        }
    }

    public void checkDescriptionsTexts() {
        for (SelenideElement description : descriptions) {
            description.shouldBe(visible);
        }
    }

    public void checkCheckboxes() {
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
    }

    public void checkUserTable() {
        for (UserTable user : UserTable.values()) {
            numbers.find(text(String.valueOf(user.getNumber()))).shouldBe(visible);
            names.find(text(user.getName())).shouldBe(visible);
            descriptions.find(text(user.getDescription())).shouldBe(visible);
        }
    }

    public void clickVIPCheckboxByName(String... names) {
        for (String name : names) {
            checkboxes.find(id(getUserByName(name).getCheckboxId())).click();
        }
    }

    public void checkVIPCheckboxStatus(String status) {
        logs.find(text(status)).shouldBe(visible);
    }

    public void clickDropdownByName(String... names) {
        for (String name : names) {
            checkboxes.get(getUserByName(name).getNumber() - 1).click();
        }
    }

    public void checkDropdownOptions() {
        for (TypeDropdown typeDropdown : TypeDropdown.values()) {
            dropdownOptions.find(text(typeDropdown.toString())).should(exist);
        }
    }
}
