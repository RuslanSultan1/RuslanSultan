package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import enums.LoginInfo;
import enums.ServiceMenu;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
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
    private List<SelenideElement> HeaderServiceMenu;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement LeftServiceButton;

    @FindBy(css = ".menu-title[index='3'] li")
    private List<SelenideElement> LeftServiceMenu;

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
        for (int i = 0; i < values.length; i++) {
            if (i < 4) {
                HeaderServiceMenu.get(i).should(exist);
                HeaderServiceMenu.get(i).shouldHave(text(values[i].toString()));
            } else {
                HeaderServiceMenu.get(i + 1).should(exist);
                HeaderServiceMenu.get(i + 1).shouldHave(text(values[i].toString()));
            }
        }
    }

    public void checkLeftServiceMenu(ServiceMenu[] values) {
        LeftServiceButton.click();
        for (int i = 0; i < values.length; i++) {
            if (i < 4) {
                LeftServiceMenu.get(i).should(exist);
                LeftServiceMenu.get(i).shouldHave(text(values[i].toString()));
            } else {
                LeftServiceMenu.get(i + 1).should(exist);
                LeftServiceMenu.get(i + 1).shouldHave(text(values[i].toString()));
            }
        }
    }

    public void openDiffElPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.get(6).click();
    }
    public void openDatesPage() {
        HeaderServiceButton.click();
        HeaderServiceMenu.get(1).click();
    }

}
