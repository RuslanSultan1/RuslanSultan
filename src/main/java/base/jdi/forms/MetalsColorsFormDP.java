package base.jdi.forms;

import base.jdi.entities.MetalColorsFormStateDP;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsFormDP extends Form<MetalColorsFormStateDP> {
    @FindBy(css = "#odds-selector")
    private RadioButtons oddRadios;
    @FindBy(css = "#even-selector")
    private RadioButtons evenRadios;
    @FindBy(css = "#submit-button")
    private Button submitButton;
    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist color;
    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist metals;
    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private static Droplist vegetables1;
    @FindBy(css = "#elements-checklist label")
    private static WebList checkboxes;

    private void selectVegetables(MetalColorsFormStateDP state) {
        vegetables1.select(vegetables1.getSelected());
        for (String vegetable : state.vegetables) {
            vegetables1.select(vegetable);
        }
    }

    private void selectNatElCheckboxes(MetalColorsFormStateDP state) {
        checkboxes.select(state.elements.toArray(new String[0]));
    }

    private void selectRadios(MetalColorsFormStateDP state) {
        oddRadios.select(state.summary.get(0).toString());
        evenRadios.select(state.summary.get(1).toString());
    }

    @Override
    public void submit(MetalColorsFormStateDP state, String buttonName) {
        selectRadios(state);
        selectVegetables(state);
        selectNatElCheckboxes(state);
        super.submit(state, buttonName);
    }
}
