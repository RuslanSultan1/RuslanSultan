package hw8;

import base.jdi.JDISite;
import base.jdi.entities.MetalColorsFormStateDP;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.lang.reflect.Type;
import java.util.Map;

import static base.jdi.entities.User.PETER;
import static enums.HeaderMenu.METALS_COLORS;

public class MetalColorsPageTestWithDataProvider {
    @DataProvider
    private Object[][] jsonDataProvider() throws FileNotFoundException {
        JsonElement jsonElement = new JsonParser().parse(new FileReader
                ("src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json"));
        // TODO Your script should not depends on test data names
        // TODO Take a look on TypeToken from Gson library
        Type itemsMapType = new TypeToken<Map<String, MetalColorsFormStateDP>>() {
        }.getType();
        Map<String, MetalColorsFormStateDP> mapItemsDes = new Gson().fromJson(jsonElement, itemsMapType);
        Object[][] result = new Object[mapItemsDes.size()][1];
        int j = 0;
        for (MetalColorsFormStateDP stateDP : mapItemsDes.values()) {
            result[j++][0] = stateDP;
        }
        return result;
    }

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test(dataProvider = "jsonDataProvider")
    public void metalColorsPageTestWithDataProvider(MetalColorsFormStateDP state) {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        JDISite.indexPageJdi.openPage(METALS_COLORS);
        JDISite.metalsColorsPageJdiDP.submitForm(state);
        JDISite.metalsColorsPageJdiDP.checkResults(state);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }
}