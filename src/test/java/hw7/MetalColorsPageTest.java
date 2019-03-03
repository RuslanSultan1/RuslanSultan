package hw7;

import base.jdi.JDISite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.entities.MetalColorsFormState.STATE1;
import static base.jdi.entities.User.*;
import static enums.HeaderMenu.METALS_COLORS;

public class MetalColorsPageTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void metalColorsPageTest() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        JDISite.indexPageJdi.openPage(METALS_COLORS);
        JDISite.metalsColorsPageJdi.submitForm(STATE1);
        JDISite.metalsColorsPageJdi.checkResults(STATE1);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}