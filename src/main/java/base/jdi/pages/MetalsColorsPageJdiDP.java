package base.jdi.pages;

import base.jdi.entities.MetalColorsFormStateDP;
import base.jdi.forms.MetalsColorsFormDP;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Text;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.Is.is;

public class MetalsColorsPageJdiDP extends WebPage {
    @FindBy(css = ".results")
    private Text results;

    MetalsColorsFormDP metalsColorsFormDP;

    public void submitForm(MetalColorsFormStateDP state) {
        metalsColorsFormDP.submit(state, "submit");
    }


    public void checkResults(MetalColorsFormStateDP state) {
        String elementsList = state.elements.toString();
        String vegetablesList = state.vegetables.toString();
        results.assertThat().text(is("Summary: " + (state.summary.get(0) + state.summary.get(1)) +
                "\nElements: " + elementsList.substring(1, elementsList.length() - 1) +
                "\nColor: " + state.color +
                "\nMetal: " + state.metals +
                "\nVegetables: " + vegetablesList.substring(1, vegetablesList.length() - 1)));
    }
}
