package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.SakilaDatabaseApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SakilaTest {
    @Test
    public void testOne(){
        boolean testReturn = SakilaDatabaseApplication.testTest();
        assertEquals(true, testReturn,"Test didnt return expected boolean.");
    }
}