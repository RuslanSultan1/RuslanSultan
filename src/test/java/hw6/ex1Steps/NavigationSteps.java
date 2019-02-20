package hw6.ex1Steps;

import cucumber.api.java.en.Given;
import pageObjects.hw6.Hw6IndexPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LoginInfo.INDEX_PAGE_URL;

public class NavigationSteps {
    static Hw6IndexPage indexPage;

    @Given("^I open EPAM JDI site$")
    public void iOpenEpamJdiPage() {
        open(INDEX_PAGE_URL.toString());
        getWebDriver().manage().window().maximize();
        indexPage = new Hw6IndexPage();
    }
}
