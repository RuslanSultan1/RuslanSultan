package base.jdi.forms;

import base.jdi.entities.MetalColorsFormState;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.*;
import enums.NatureElementsCheckboxes;
import enums.VegetablesDropdown;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsForm extends Form<MetalColorsFormState> {
    @FindBy(css = "#odds-selector")
    private RadioButtons oddRadios;
    @FindBy(css = "#even-selector")
    private RadioButtons evenRadios;
    @FindBy(css = "#submit-button")
    private Button submitButton;
    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist colors;
    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist metals;
    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private static Droplist vegetables;
    @FindBy(css = "#elements-checklist label")
    private static WebList checkboxes;

    private void selectVegetables(MetalColorsFormState state) {
        vegetables.select(vegetables.getSelected());
        for (VegetablesDropdown vegetable : state.vegetablesList) {
            vegetables.select(vegetable);
        }
    }

    private void selectNatElCheckboxes(MetalColorsFormState state) {
        checkboxes.select((NatureElementsCheckboxes[]) state.checkboxList.toArray());
    }

    @Override
    public void submit(MetalColorsFormState state, String buttonName) {
        selectVegetables(state);
        selectNatElCheckboxes(state);
        super.submit(state, buttonName);
    }
}
