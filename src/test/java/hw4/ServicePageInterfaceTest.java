package hw4;

import base.SelenideBase;
import pageObjects.hw4.IndexPage;
import pageObjects.hw4.ServicePage;
import enums.ServiceMenu;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.DropdownOptions.YELLOW;
import static enums.LoginInfo.*;
import static enums.Radios.SELEN;

public class ServicePageInterfaceTest extends SelenideBase {
    private IndexPage indexPage;
    private ServicePage servicePage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open("https://epam.github.io/JDI/index.html");
        indexPage=page(IndexPage.class);
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
        servicePage.selectCheckbox(WATER);
        servicePage.checkCheckboxStatus(WATER,true);
        servicePage.selectCheckbox(WIND);
        servicePage.checkCheckboxStatus(WIND,true);

        //13 Select radio
        servicePage.selectRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        servicePage.checkRadioStatus(SELEN);

        //15 Select in dropdown
        servicePage.selectDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        servicePage.checkDropdownStatus(YELLOW);

        //17 Unselect and assert checkboxes
        //18 Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox.
        servicePage.unselectCheckbox(WATER);
        servicePage.checkCheckboxStatus(WATER,false);
        servicePage.unselectCheckbox(WIND);
        servicePage.checkCheckboxStatus(WIND,false);
    }
}