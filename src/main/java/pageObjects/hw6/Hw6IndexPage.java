package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.IconsTexts;
import enums.ServiceMenu;
import enums.User;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static enums.MainHeaders.MAIN_TITLE;
import static enums.MainHeaders.MAIN_TXT;
import static enums.ServiceMenu.DIFFERENT_ELEMENTS;
import static enums.ServiceMenu.USER_TABLE;
import static org.testng.Assert.assertEquals;

public class Hw6IndexPage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(id = "user-name")
    private SelenideElement userIcon;
    @FindBy(css = ".icon-practise")
    private SelenideElement iconPractise;

    @FindBy(css = ".icon-custom")
    private SelenideElement iconCustom;

    @FindBy(css = ".icon-multi")
    private SelenideElement iconMulti;

    @FindBy(css = ".icon-base")
    private SelenideElement iconBase;

    @FindBy(css = ".benefits .col-sm-3")
    private ElementsCollection benefitsTexts;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainTxt;

    @FindBy(css = ".nav .dropdown-toggle")
    private SelenideElement HeaderServiceButton;

    @FindBy(css = ".dropdown-menu li")
    private ElementsCollection HeaderServiceMenu;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement LeftServiceButton;

    @FindBy(css = ".menu-title[index='3'] li")
    private ElementsCollection LeftServiceMenu;

    public Hw6IndexPage() {
        page(this);
    }

    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }
    public void checkTitle(String indexPageTitle) {
        assertEquals(title(), indexPageTitle);
    }

    public void checkUser(String userName) {
        userIcon.shouldHave(text(userName));
    }

    public void checkIndexPageInterface() {
        iconPractise.shouldBe(visible);
        iconCustom.shouldBe(visible);
        iconMulti.shouldBe(visible);
        iconBase.shouldBe(visible);
        for (IconsTexts iconText : IconsTexts.values()) {
            benefitsTexts.find(text(iconText.toString())).shouldBe(visible);
        }
        mainTitle.should(visible, text(MAIN_TITLE.toString()));
        mainTxt.should(visible, text(MAIN_TXT.toString()));
    }

    public void cliclHeaderServiceButton() {
        HeaderServiceButton.click();
    }

    public void checkHeaderServiceMenu() {
        for (ServiceMenu value : ServiceMenu.values()) {
            HeaderServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    public void clickLeftServiceButton() {
        LeftServiceButton.click();
    }

    public void checkLeftServiceMenu() {
        for (ServiceMenu value : ServiceMenu.values()) {
            LeftServiceMenu.find(text(value.toString())).should(exist);
        }
    }
    public void openDiffElPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.find(text(DIFFERENT_ELEMENTS.toString())).click();
    }
    public void openUserTablePage() {
        HeaderServiceMenu.find(text(USER_TABLE.toString())).click();
    }
}
