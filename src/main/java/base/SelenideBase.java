package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Browsers.CHROME;

public abstract class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = CHROME;
        Configuration.startMaximized = true;
    }
}