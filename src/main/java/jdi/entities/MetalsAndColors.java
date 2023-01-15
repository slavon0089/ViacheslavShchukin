package jdi.entities;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class MetalsAndColors extends DataClass<MetalsAndColors> {
    @JsonProperty("summary")
    public List<String> summary;

    @JsonProperty("elements")
    public List<String> elements;

    @JsonProperty("color")
    public String color;

    @JsonProperty("metals")
    public String metals;

    @JsonProperty("vegetables")
    public List<String> vegetables;

    public MetalsAndColors() {

    }

    public MetalsAndColors(List<String> summary, List<String> elements, String color,
                           String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public List<String> getResultLog() {
        int sumOfOddEvenNumbers = Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1));
        List<String> result = new ArrayList<>();
        String elementsEarth = String.join(", ", elements);
        String vegetables = String.join(", ", getVegetables());
        result.add("Color: " + color);
        result.add("Metal: " + metals);
        result.add("Summary: " + sumOfOddEvenNumbers);
        result.add("Elements: " + elementsEarth);
        result.add("Vegetables: " + vegetables);
        return result;
    }
}
