package hw3;

import base.SeleniumBase;
import pageObjects.hw3.IndexPage;
import enums.HeaderSection;
import enums.IconsTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static enums.JDI_Info.*;
import static enums.LoginInfo.*;
import static enums.MainHeaders.*;

public class PageObjectTest extends SeleniumBase {
    private IndexPage indexPage;
    private WebDriver driver;

    @BeforeMethod
    public void initTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void closeTest() {
        driver.close();
    }

    @Test
    public void pageObjectTest() {
        //1 Open test site by URL
        // TODO Take a look on IdexPage(WebDriver driver) {...} constructor
        indexPage.open();

        //2 Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_TITLE);

        //3 Perform login
        indexPage.login(LOGIN, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUser(USER_NAME);

        //5 Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPage.checkHeaderSection(HeaderSection.values());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkIcons();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        // TODO You can pass che whole enum into this method at once, take a look on enum default methods
        indexPage.checkIconTexts(IconsTexts.values());

        //9 Assert a text of the main headers
        indexPage.checkMainHeaders(MAIN_TITLE, MAIN_TXT);

        //10 Assert that there is the iframe in the center of page
        //   Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        //   Switch to original window back
        indexPage.checkIframe();

        //11 Assert a text of the sub header
        //   Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkSubheader(SUBHEADER_TITLE, JDI_URL);

        //12 Assert that there is Left Section
        indexPage.checkLeftSection();

        //13 Assert that there is Footer
        indexPage.checkFooter();
    }
}