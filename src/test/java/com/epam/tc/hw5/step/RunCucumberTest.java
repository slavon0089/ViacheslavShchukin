package com.epam.tc.hw5.step;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/epam/tc/hw5/step"},
        publish = true)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
