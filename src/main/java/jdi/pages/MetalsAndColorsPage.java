package jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import jdi.entities.MetalsAndColors;
import jdi.forms.MetalsAndColorsForm;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsPage extends WebPage {

    public MetalsAndColorsForm metalsAndColorsForm;


    @Css(".results li")
    private WebList log;

    public void fillMetalAndColorForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fillForm(metalsAndColors);
    }

    public void assertResultLog(MetalsAndColors metalsAndColors) {
        Assertions.assertThat(metalsAndColors.getResultLog()).hasSameElementsAs(actualResultLog());
    }

    public List<String> actualResultLog() {
        List<String> result = new ArrayList<>();
        log.forEach(els -> {
            result.add(els.getText());
        });
        return result;
    }
}
