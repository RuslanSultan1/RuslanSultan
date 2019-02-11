package hw4;

import base.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.hw4.DatesPage;
import pageObjects.hw4.IndexPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LoginInfo.*;

public class DatesPageSlidersTest extends SelenideBase {
    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_PAGE_URL.toString());
        getWebDriver().manage().window().maximize();
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void datesPageSlidersTest() {
        //2 Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_TITLE);

        //3 Perform login
        indexPage.login(LOGIN, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUser(USER_NAME);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position
        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.setAndCheckSliders(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right
        // slider - the most left position.
        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.setAndCheckSliders(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position.
        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.setAndCheckSliders(100, 100);

        //12 Using drag-and-drop set Range sliders.
        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.setAndCheckSliders(30, 70);
    }
}
