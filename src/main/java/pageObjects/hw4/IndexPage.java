package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.LoginInfo;
import enums.ServiceMenu;
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

    public void login(LoginInfo name, LoginInfo password) {
        loginIcon.click();
        userField.sendKeys(name.toString());
        passwordField.sendKeys(password.toString());
        submitButton.click();
    }

    public void checkTitle(LoginInfo indexPageTitle) {
        assertEquals(title(), indexPageTitle.toString());
    }

    public void checkUser(LoginInfo userName) {
        userIcon.shouldBe(visible);
        userIcon.shouldHave(text(userName.toString()));
    }

    public void checkHeaderServiceMenu(ServiceMenu[] values) {
        HeaderServiceButton.click();
        for (ServiceMenu value : values) {
            HeaderServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    public void checkLeftServiceMenu(ServiceMenu[] values) {
        LeftServiceButton.click();
        for (ServiceMenu value : values) {
            LeftServiceMenu.find(text(value.toString())).should(exist);
        }
    }

    public void openDiffElPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.find(text(DIFFERENT_ELEMENTS.toString())).click();
    }

    public void openDatesPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.find(text(DATES.toString())).click();
    }

}
