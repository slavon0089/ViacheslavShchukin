package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends AbstractTest {
    @DataProvider
    public static Object[][] sumCorrectData() {
        return new Object[][]{
                {1.0, 2.0, 3.0},
                {-1.0, 0.0, -1.0},
                {1, 0, 1},
                {0, 10, 10},
                {15, 20, 35}
        };
    }

    @Test(dataProvider = "sumCorrectData")
    public void positiveSumTest(double a, double b, double result) {
        double act = calculator.sum(a, b);
        assertThat(act).isEqualTo(result);
    }


}
