package jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import java.util.ArrayList;
import java.util.List;
import jdi.entities.MetalsAndColors;
import jdi.forms.MetalsAndColorsForm;
import org.assertj.core.api.Assertions;

public class MetalsAndColorsPage extends WebPage {

    public MetalsAndColorsForm metalsAndColorsForm;


    @Css(".results li")
    private WebList log;

    public void fillMetalAndColorForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
    }

    public void assertResultLog(MetalsAndColors metalsAndColors) {
        Assertions.assertThat(actualResultLog()).hasSameElementsAs(metalsAndColors.getResultLog());
    }

    public List<String> actualResultLog() {
        List<String> result = new ArrayList<>();

        log.stream()
               .forEach(els -> {
                   result.add(els.getText());
               });

        return result;
    }
}
