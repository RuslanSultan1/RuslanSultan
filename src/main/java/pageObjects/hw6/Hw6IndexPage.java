package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static enums.HeaderSection.SERVICE;
import static enums.MainHeaders.MAIN_TITLE;
import static enums.MainHeaders.MAIN_TXT;
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

    @FindBy(css = ".nav>li")
    private ElementsCollection HeaderMenu;

    @FindBy(css = ".dropdown-menu li")
    private ElementsCollection HeaderServiceMenu;

    @FindBy(css = ".sidebar-menu>li")
    private ElementsCollection LeftMenu;

    @FindBy(css = ".menu-title[index='3'] li")
    private ElementsCollection LeftServiceMenu;

    public Hw6IndexPage() {
        page(this);
    }

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkTitle(LoginInfo indexPageTitle) {
        assertEquals(title(), indexPageTitle.toString());
    }

    public void checkUserName(User user) {
        userIcon.shouldHave(text(user.username));
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

    public void clickHeaderButton(HeaderSection subcategory) {
        HeaderMenu.find(text(subcategory.toString())).click();
    }

    public void checkHeaderServiceMenu(List<ServiceMenu> values) {
        for (ServiceMenu value : values) {
            HeaderServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    public void clickLeftButton(HeaderSection subcategory) {
        LeftMenu.find(text(subcategory.toString())).click();
    }

    public void checkLeftServiceMenu(List<ServiceMenu> values) {
        for (ServiceMenu value : values) {
            LeftServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    public void openPage(ServiceMenu page) {
        HeaderMenu.find(text(SERVICE.toString())).click();
        HeaderServiceMenu.find(text(page.toString())).click();
    }

    public void openPage1(ServiceMenu page) {
        HeaderServiceMenu.find(text(page.toString())).click();
    }
}
