package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CosTest extends AbstractTest {

    @DataProvider
    public static Object[][] cosCorrectData() {
        return new Object[][]{
                {0.7853981633974483, 0.7081067811865475},
                {1.5533430342749532, 0.0174524064372836},
                {0.017453292519943295, 0.9998476951563913},
                {0.0, 1.0}
        };
    }

    @Test(dataProvider = "cosCorrectData")
    public void positiveCosTest(double a, double result) {
        double act = calculator.cos(a);
        assertThat(act).isEqualTo(result);
    }

}
