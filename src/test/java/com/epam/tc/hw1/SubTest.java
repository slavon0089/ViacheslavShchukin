package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubTest extends AbstractTest {

    @DataProvider
    public static Object[][] subCorrectData() {
        return new Object[][]{
                {1.0, 2.0, -1.0},
                {-1.0, 0.0, -1.0},
                {1, 0, 1},
                {0, 10, -10},
                {25, 20, 5}
        };
    }

    @Test(dataProvider = "subCorrectData")
    public void positiveSubTest(double a, double b, double result) {
        var act = calculator.sub(a, b);
        assertThat(act).isEqualTo(result);
    }
}
