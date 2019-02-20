package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceMenu;
import enums.UserTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = "th")
    private ElementsCollection tableColumns;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "tr>td:nth-of-type(4n-3)")
    private ElementsCollection numbers;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    @FindBy(css = "tr:nth-of-type(2) option")
    private ElementsCollection dropdownOptions;

    public void checkTitle(ServiceMenu userTablePageTitle) {
        assertEquals(title(), userTablePageTitle.toString());
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

    public void checkUserTable(List<String> values) {
        for (int i = 0; i < 3; i++) {
            tableColumns.find(text(values.get(i))).should(exist);
        }
        for (int i = 3; i < values.size(); i++) {
            if (i % 3 == 0) numbers.find(text(values.get(i))).shouldBe(visible);
            if (i % 3 == 1) names.find(text(values.get(i))).shouldBe(visible);
            if (i % 3 == 2) descriptions.find(text(values.get(i))).shouldBe(visible);
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

    public void checkDropdownOptions(List<String> userTypes) {
        for (String userType : userTypes) {
            dropdownOptions.find(text(userType)).should(exist);
        }
    }
}
