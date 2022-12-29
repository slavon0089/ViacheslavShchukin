package com.epam.tc.hw5.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DaysOfWeekStep {
    @Given("today is Sunday")
    public void todayIsSunday() {
        System.out.println("today is Sunday");
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        System.out.println("Is it Friday?");
    }

    @Then("I should be told Nope")
    public void iShouldBeToldNope() {
        System.out.println("Nope");
    }

    @And("Some text")
    public void some_text() {
        System.out.println(24);
    }
}
