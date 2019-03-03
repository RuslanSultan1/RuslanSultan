package hw5;

import base.SelenideBase;
import enums.ServiceMenu;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.IndexPage;
import pageObjects.hw4.ServicePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.MetalsOptions.SELEN;
import static enums.DropdownColorOptions.YELLOW;
import static enums.LoginInfo.*;
import static enums.NatureElementsCheckboxes.WATER;
import static enums.NatureElementsCheckboxes.WIND;


@Feature("Smoke tests")
@Story("Test that will fail")
@Listeners(AllureAttachmentListener.class)
public class BrokenTest extends SelenideBase {
    private IndexPage indexPage;
    private ServicePage servicePage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_PAGE_URL.toString());
        getWebDriver().manage().window().maximize();
        indexPage = page(IndexPage.class);
        servicePage = page(ServicePage.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void servicePageInterfaceTest() {
        //2 Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_TITLE);

        //3 Perform login
        indexPage.login(LOGIN, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUser(USER_NAME);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderServiceMenu(ServiceMenu.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftServiceMenu(ServiceMenu.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openDiffElPage();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePage.checkDiffElPageInterface();

        //9 Assert that there is Right Section
        servicePage.checkRightSection();

        //10 Assert that there is Left Section
        servicePage.checkLeftSection();

        //11 Select checkboxes
        //12 Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        servicePage.clickNatureElCheckbox(WATER, WIND);
        servicePage.checkNatureElCheckboxStatus(WATER, false);
        servicePage.checkNatureElCheckboxStatus(WIND, true);

        //13 Select radio
        servicePage.selectColorRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        servicePage.checkColorRadioStatus(SELEN);

        //15 Select in dropdown
        servicePage.selectDropdownColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        servicePage.checkDropdownColorStatus(YELLOW);

        //17 Unselect and assert checkboxes
        //18 Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox.
        servicePage.clickNatureElCheckbox(WATER, WIND);
        servicePage.checkNatureElCheckboxStatus(WATER, false);
        servicePage.checkNatureElCheckboxStatus(WIND, false);
    }
}