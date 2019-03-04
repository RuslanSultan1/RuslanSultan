package base.jdi.pages;

import base.jdi.entities.MetalColorsFormState;
import base.jdi.forms.MetalsColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Text;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.StringContains.containsString;

public class MetalsColorsPageJdi extends WebPage {
    @FindBy(css = ".results")
    private Text results;

    MetalsColorsForm metalsColorsForm;

    public void submitForm(MetalColorsFormState state) {
        metalsColorsForm.submit(state, "submit");
    }


    public void checkResults(MetalColorsFormState state) {
        String checkboxList = state.checkboxList.toString();
        String vegetablesList = state.vegetablesList.toString();
        results.assertThat().text(containsString("Summary: " + (state.evenRadios + state.oddRadios) +
                "\nElements: " + checkboxList.substring(1, checkboxList.length() - 1) +
                "\nColor: " + state.colors +
                "\nMetal: " + state.metals +
                "\nVegetables: " + vegetablesList.substring(1, vegetablesList.length() - 1)));
    }
}
