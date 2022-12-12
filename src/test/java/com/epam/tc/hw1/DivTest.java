package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivTest extends AbstractTest {

    @DataProvider
    public static Object[][] divCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {17.0, 5.0, 3.4},
                {4, 5, 0.8},
                {0, 10, 0},
                {25, 5, 5}
        };
    }

    @Test(dataProvider = "divCorrectData")
    public void positiveDivTest(double a, double b, double result) {
        var act = calculator.div(a, b);
        assertThat(act).isEqualTo(result);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void negativeDivOnZeroLongTest() {
        long a = 922337203685772107L;
        long b = 0;
        long result = 0;
        long act = calculator.div(a, b);
        Assert.assertEquals(act, result, 0.0001);
    }

    @Test
    public void negativeDivOnZeroDoubleTest() {
        double a = 9223.0;
        double b = 0.0;
        double result = Double.POSITIVE_INFINITY;;
        var act = calculator.div(a, b);
        Assert.assertEquals(act, result, 0.0001);
    }

    @AfterMethod
    public void after() {
        calculator = null;

    }
}
