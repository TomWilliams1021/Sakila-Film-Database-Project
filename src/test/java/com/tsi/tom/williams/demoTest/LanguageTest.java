package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageTest {

    private Language testLanguage = new Language("English");

    @Test
    void testGetLanguageId(){
        assertEquals(0, testLanguage.getLanguageId(), "getLanguageId method did not return the expected id value.");
    }

    @Test
    void testGetLanguageName(){
        assertEquals("English", testLanguage.getName(), "getName method for Language did not return the expected name string.");
    }

    @Test
    void testSetLanguageName(){
        testLanguage.setName("French");
        assertEquals("French", testLanguage.getName(), "setName method for Language did not set the name correctly.");
    }

    @Test
    void testEmptyLanguageConstructor(){
        testLanguage = new Language();
        assertEquals(null, testLanguage.getName(), "Default empty Language constructor did not work as intended.");
    }
}
