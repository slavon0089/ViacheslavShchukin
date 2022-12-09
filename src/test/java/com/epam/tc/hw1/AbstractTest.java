package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class AbstractTest {
    protected Calculator calculator;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void before() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void after() {
        calculator = null;
        softAssert = null;
    }
}
