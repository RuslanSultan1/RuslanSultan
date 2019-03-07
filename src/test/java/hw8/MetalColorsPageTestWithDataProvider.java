package hw8;

import base.jdi.JDISite;
import base.jdi.entities.MetalColorsFormStateDP;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static base.jdi.entities.User.PETER;
import static enums.HeaderMenu.METALS_COLORS;

public class MetalColorsPageTestWithDataProvider {
    @DataProvider
    private Object[][] jsonDataProvider() throws FileNotFoundException {
        JsonElement jsonElement = new JsonParser().parse(new FileReader
                ("src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json"));
        List<MetalColorsFormStateDP> statesList = new ArrayList<>();
        int i = 1;
        // TODO Your script should not depends on test data names
        // TODO Take a look on TypeToken from Gson library
        while (jsonElement.getAsJsonObject().get("data_" + i) != null) {
            JsonElement dataSet = jsonElement.getAsJsonObject().get("data_" + (i++));
            statesList.add(new Gson().fromJson(dataSet, MetalColorsFormStateDP.class));
        }
        Object[][] result = new Object[statesList.size()][1];
        int j = 0;
        for (Object[] each : result) {
            each[0] = statesList.get(j++);
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