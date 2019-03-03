package base.jdi.entities;

import enums.DropdownColorOptions;
import enums.MetalsOptions;
import enums.NatureElementsCheckboxes;
import enums.VegetablesDropdown;
import lombok.AllArgsConstructor;

import java.util.List;

import static enums.DropdownColorOptions.RED;
import static enums.MetalsOptions.SELEN;
import static enums.NatureElementsCheckboxes.FIRE;
import static enums.NatureElementsCheckboxes.WATER;
import static java.util.Arrays.asList;
import static enums.VegetablesDropdown.CUCUMBER;
import static enums.VegetablesDropdown.TOMATO;

@AllArgsConstructor
public class MetalColorsFormState {
    public static MetalColorsFormState STATE1 = new MetalColorsFormState(3, 8,
            RED, SELEN, asList(CUCUMBER, TOMATO), asList(WATER, FIRE));
    public int oddRadios;
    public int evenRadios;
    public DropdownColorOptions colors;
    public MetalsOptions metals;
    public List<VegetablesDropdown> vegetablesList;
    public List<NatureElementsCheckboxes> checkboxList;
}
