package jdi.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import jdi.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColorsForm> {

    @FindBy(css = "#elements-checklist input")
    public Checklist elementsOfEarth;

    @FindBy(name = "custom_radio_odd")
    public RadioButtons oddNumbers;

    @FindBy(name = "custom_radio_even")
    public RadioButtons evenNumbers;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown color;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @FindBy(id = "salad-dropdown")
    private Button salad;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist saladList;

    @FindBy(id = "submit-button")
    private Button submit;


    public void fillForm(MetalsAndColors metalsAndColors) {
        oddNumbers.select(metalsAndColors.summary.get(0));
        evenNumbers.select(metalsAndColors.summary.get(1));
        metalsAndColors.elements.forEach(elementsOfEarth::select);
        color.select(metalsAndColors.color);
        metals.select(metalsAndColors.metals);
        salad.click();
        saladList.select("Vegetables");
        metalsAndColors.getVegetables().forEach(saladList::select);
        submit.click();
    }

}
