package pageObjects.hw3;

import enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.LoginInfo.INDEX_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userIcon;

    @FindBy(css = "nav>.uui-navigation.nav>li")
    private List<WebElement> headers;

    @FindBy(css = ".icon-practise")
    private WebElement iconPractise;

    @FindBy(css = ".icon-custom")
    private WebElement iconCustom;

    @FindBy(css = ".icon-multi")
    private WebElement iconMulti;

    @FindBy(css = ".icon-base")
    private WebElement iconBase;

    @FindBy(css = ".benefits .col-sm-3")
    private List<WebElement> benefitsTexts;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainTxt;

    @FindBy(css = "iframe")
    private WebElement iframe;

    @FindBy(css = "[id='epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = ".text-center a")
    private WebElement subheader;

    @FindBy(css = ".uui-side-bar")
    private WebElement sideBar;

    @FindBy(css = "footer")
    private WebElement footer;

    public void open() {
        driver.get(INDEX_PAGE_URL.toString());
    }

    public void login(LoginInfo name, LoginInfo password) {
        loginIcon.click();
        userField.sendKeys(name.toString());
        passwordField.sendKeys(password.toString());
        submitButton.click();
    }

    public void checkUser(LoginInfo userName) {
        assertTrue(userIcon.isDisplayed());
        assertEquals(userIcon.getText(), userName.toString());
    }

    public void checkTitle(LoginInfo homePageTitle) {
        assertEquals(driver.getTitle(), homePageTitle.toString());
    }

    public void checkHeaderSection(HeaderSection[] values) {
        for (int i = 0; i < values.length; i++) {
            assertTrue(headers.get(i).isDisplayed());
            assertEquals(headers.get(i).getText(), values[i].toString());
        }
    }

    public void checkIcons() {
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconCustom.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconBase.isDisplayed());
    }

    public void checkIconTexts(IconsTexts[] benefits) {
        for (int i = 0; i < benefits.length; i++) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(benefitsTexts.get(i).getText(), benefits[i].toString());
        }
    }

    public void checkMainHeaders(MainHeaders title, MainHeaders txt) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), title.toString());
        assertTrue(mainTxt.isDisplayed());
        assertEquals(mainTxt.getText(), txt.toString());
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
        driver.switchTo().frame(iframe);
        assertTrue(epamLogo.isDisplayed());
        driver.switchTo().parentFrame();
    }

    public void checkSubheader(JDI_Info title, JDI_Info url) {
        assertEquals(subheader.getText(), title.toString());
        assertEquals(subheader.getAttribute("href"), url.toString());
    }

    public void checkLeftSection() {
        assertTrue(sideBar.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}