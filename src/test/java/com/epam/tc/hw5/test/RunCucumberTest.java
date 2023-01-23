package com.epam.tc.hw5.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        publish = true)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
