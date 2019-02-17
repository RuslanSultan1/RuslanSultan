package hw6.ex2Steps;

import pageObjects.hw6.Hw6IndexPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.User;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LoginInfo.INDEX_PAGE_URL;

public class NavigationSteps {
    @Given("^I am on 'Home Page'$")
    public void iAmOnHomePage() {
        open(INDEX_PAGE_URL.toString());
        getWebDriver().manage().window().maximize();
    }

    @And("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(User user){
        new Hw6IndexPage().login(user);
    }
}
