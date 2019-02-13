package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.LoginInfo;
import enums.ServiceMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static enums.ServiceMenu.DATES;
import static enums.ServiceMenu.DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertEquals;

public class IndexPage {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userIcon;

    @FindBy(css = ".nav .dropdown-toggle")
    private SelenideElement HeaderServiceButton;

    @FindBy(css = ".dropdown-menu li")
    private ElementsCollection HeaderServiceMenu;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement LeftServiceButton;

    @FindBy(css = ".menu-title[index='3'] li")
    private ElementsCollection LeftServiceMenu;

    @Step("Trying logging in using name: {name} with password: {password}.")
    public void login(LoginInfo name, LoginInfo password) {
        loginIcon.click();
        userField.sendKeys(name.toString());
        passwordField.sendKeys(password.toString());
        submitButton.click();
    }

    @Step("Checking title of the Index page, which should be equal to {indexPageTitle}.")
    public void checkTitle(LoginInfo indexPageTitle) {
        assertEquals(title(), indexPageTitle.toString());
    }

    @Step("Checking user name in the top-right side of screen that user {userName} is loggined.")
    public void checkUser(LoginInfo userName) {
        userIcon.shouldBe(visible);
        userIcon.shouldHave(text(userName.toString()));
    }

    @Step("Clicking on \"Service\" subcategory in the header and checking that drop down contains options: {values}.")
    public void checkHeaderServiceMenu(ServiceMenu[] values) {
        HeaderServiceButton.click();
        for (ServiceMenu value : values) {
            HeaderServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    @Step("Clicking on \"Service\" subcategory in the left section and checking that drop down contains options {values}.")
    public void checkLeftServiceMenu(ServiceMenu[] values) {
        LeftServiceButton.click();
        for (ServiceMenu value : values) {
            LeftServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    @Step("Opening through the header menu Service -> Different Elements Page")
    public void openDiffElPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.find(text(DIFFERENT_ELEMENTS.toString())).click();
    }

    @Step("Opening through the header menu Service -> Dates Page")
    public void openDatesPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.find(text(DATES.toString())).click();
    }

}
