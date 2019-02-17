package hw6.ex1Steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LoginInfo.INDEX_PAGE_URL;

public class NavigationSteps {

    @Given("^I open EPAM JDI site$")
    public void iOpenEpamJdiPage() {
        open(INDEX_PAGE_URL.toString());
        getWebDriver().manage().window().maximize();
    }
}
