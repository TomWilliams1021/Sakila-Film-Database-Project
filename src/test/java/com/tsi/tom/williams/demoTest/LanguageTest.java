package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageTest {

    private Language testLanguage = new Language("English");

    @Test
    public void testGetLanguageId(){
        assertEquals(0, testLanguage.getLanguage_id(), "getLanguageId method did not return the expected id value.");
    }

    @Test
    public void testGetLanguageName(){
        assertEquals("English", testLanguage.getName(), "getName method for Language did not return the expected name string.");
    }

    @Test
    public void testSetLanguageName(){
        testLanguage.setName("French");
        assertEquals("French", testLanguage.getName(), "setName method for Language did not set the name correctly.");
    }
}
