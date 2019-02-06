package base.hw3;

import enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static enums.LoginInfo.INDEX_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
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

    @FindBy(css = ".uui-header [href='index.html']")
    private WebElement headerIndex;

    @FindBy(css = ".uui-header [href='contacts.html']")
    private WebElement headerContacts;

    @FindBy(css = ".uui-header [data-toggle='dropdown']")
    private WebElement headerService;

    @FindBy(css = ".uui-header [href='metals-colors.html']")
    private WebElement headerMetalsAndColors;

    @FindBy(css = ".icon-practise")
    private WebElement iconPractise;

    @FindBy(css = ".icon-custom")
    private WebElement iconCustom;

    @FindBy(css = ".icon-multi")
    private WebElement iconMulti;

    @FindBy(css = ".icon-base")
    private WebElement iconBase;

    @FindBy(css = ".benefits .col-sm-3:nth-of-type(1)")
    private WebElement textPractise;

    @FindBy(css = ".benefits .col-sm-3:nth-of-type(2)")
    private WebElement textCustom;

    @FindBy(css = ".benefits .col-sm-3:nth-of-type(3)")
    private WebElement textMulti;

    @FindBy(css = ".benefits .col-sm-3:nth-of-type(4)")
    private WebElement textBase;

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

    public void open(WebDriver driver) {
        driver.get(INDEX_PAGE_URL.toString());
    }

    @FindBy(css = ".uui-side-bar")
    private WebElement sideBar;

    @FindBy(css = "footer")
    private WebElement footer;

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

    public void checkTitle(WebDriver driver, LoginInfo homePageTitle) {
        assertEquals(driver.getTitle(), homePageTitle.toString());
    }

    public void checkHeaderSection(HeaderSection home, HeaderSection contact, HeaderSection service,
                                   HeaderSection metalsAndColors) {
        // TODO This will be better with for loop,
        // TODO you can create locator that provide you with the list of elements
        assertTrue(headerIndex.isDisplayed());
        assertEquals(headerIndex.getText(), home.toString());
        assertTrue(headerContacts.isDisplayed());
        assertEquals(headerContacts.getText(), contact.toString());
        assertTrue(headerService.isDisplayed());
        assertEquals(headerService.getText(), service.toString());
        assertTrue(headerMetalsAndColors.isDisplayed());
        assertEquals(headerMetalsAndColors.getText(), metalsAndColors.toString());
    }

    public void checkIcons() {
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconCustom.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconBase.isDisplayed());
    }

    public void checkIconTexts(IconsTexts benefitPractise, IconsTexts benefitCustom, IconsTexts benefitMulti,
                               IconsTexts benefitBase) {
        // TODO This will be better with for loop
        assertTrue(textPractise.isDisplayed());
        assertEquals(textPractise.getText(), benefitPractise.toString());
        assertTrue(textCustom.isDisplayed());
        assertEquals(textCustom.getText(), benefitCustom.toString());
        assertTrue(textMulti.isDisplayed());
        assertEquals(textMulti.getText(), benefitMulti.toString());
        assertTrue(textBase.isDisplayed());
        assertEquals(textBase.getText(), benefitBase.toString());
    }

    public void checkMainHeaders(MainHeaders title, MainHeaders txt) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), title.toString());
        assertTrue(mainTxt.isDisplayed());
        assertEquals(mainTxt.getText(), txt.toString());
    }

    public void checkIframe(WebDriver driver) {
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