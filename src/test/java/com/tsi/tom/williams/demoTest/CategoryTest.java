package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.Category;
import com.tsi.tom.williams.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    private Category testCategory = new Category("testCategoryName");
    private Set<Film> testFilm = new HashSet<>(){{
        add (new Film("Test Film", "Test Description", 1, 90, "PG", "Test Special Features"));
    }};

    @Test
    public void testGetCategoryId(){
        assertEquals(0, testCategory.getCategoryId(), "getCategoryId method did not return the expected Id value.");
    }

    @Test
    public void testGetCategoryName(){
        assertEquals("testCategoryName", testCategory.getName(), "getName method for Category did not return the expected name string.");
    }

    @Test
    public void testSetCategoryName(){
        testCategory.setName("setNameTest");
        assertEquals("setNameTest", testCategory.getName(), "setName method for Category did not set the first name correctly.");
    }

    @Test
    public void testGetFilms(){
        testCategory.setFilms(testFilm);
        assertEquals(testFilm, testCategory.getFilms(), "The getFilms method in Category did not get the expected film set value.");
    }

    @Test
    public void testSetFilms(){
        testFilm.add (new Film("Test Film 2", "Test Description 2", 1, 90, "PG", "Test Special Features"));
        testCategory.setFilms(testFilm);
        assertEquals(testFilm, testCategory.getFilms(), "The setFilms method in Category did not set the film set to the expected value.");
    }
}
