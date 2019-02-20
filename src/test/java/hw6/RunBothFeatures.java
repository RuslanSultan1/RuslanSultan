package hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = "classpath:hw6",
        glue = {"classpath:hw6.ex1Steps", "classpath:hw6.ex2Steps"}
)
public class RunBothFeatures extends AbstractTestNGCucumberTests {
    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

}
