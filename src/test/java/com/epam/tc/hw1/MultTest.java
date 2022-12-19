package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MultTest extends AbstractTest {

    @DataProvider
    public static Object[][] multCorrectData() {
        return new Object[][]{
                {5.0, 2.0, 10.0},
                {-1.0, 0.0, 0.0},
                {4, 2, 8},
                {148, 10, 1480},
                {25, 20, 500}
        };
    }

    @Test(dataProvider = "multCorrectData")
    public void positiveMultDoubleTest(double a, double b, double result) {
        var act = calculator.mult(a, b);
        assertThat(act).isEqualTo(result);
    }

}
