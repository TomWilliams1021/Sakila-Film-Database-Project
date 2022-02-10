package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.Actor;
import com.tsi.tom.williams.demo.Category;
import com.tsi.tom.williams.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    private Film testFilm = new Film("Test Film", "Test Description", 1, 90, "PG", "Test Special Features");
    private Set<Actor> testActorSet = new HashSet<>(){{
        add(new Actor("Test","Actor"));
    }};
    private Set<Category> testCategorySet = new HashSet<>(){{
        add(new Category("testCategoryName"));
    }};



    @Test
    public void testGetFilmId(){
        assertEquals(0, testFilm.getFilmId(), "getFilmId method did not return the expected Id value.");
    }

    @Test
    public void testGetFilmTitle(){
        assertEquals("Test Film", testFilm.getTitle(), "getTitle method for Film did not return the expected Title string.");
    }

    @Test
    public void testSetFilmTitle(){
        testFilm.setTitle("Set Title Test String");
        assertEquals("Set Title Test String", testFilm.getTitle(), "setTitle method for Film did not set the Title string to the expected value.");
    }

    @Test
    public void testGetFilmDescription(){
        assertEquals("Test Description", testFilm.getDescription(), "getDescription method for Film did not return the expected Description string.");
    }

    @Test
    public void testSetFilmDescription(){
        testFilm.setDescription("Set Description Test String");
        assertEquals("Set Description Test String", testFilm.getDescription(), "setDescription method for Film did not set the Description string to the expected value.");
    }

    @Test
    public void testGetFilmLanguageId(){
        assertEquals(1, testFilm.getLanguageId(), "getLanguageId method for Film did not return the expected Id integer.");
    }

    @Test
    public void testSetFilmLanguageId(){
        testFilm.setLanguageId(2);
        assertEquals(2, testFilm.getLanguageId(), "setLanguageId method for Film did not set the Id integer to the expected value.");
    }

    @Test
    public void testGetFilmLength(){
        assertEquals(90, testFilm.getLength(), "getLength method for Film did not return the expected Length integer.");
    }

    @Test
    public void testSetFilmLength(){
        testFilm.setLength(80);
        assertEquals(80, testFilm.getLength(), "setLength method for Film did not set the Length integer to the expected value.");
    }

    @Test
    public void testGetFilmRating(){
        assertEquals("PG", testFilm.getRating(), "getRating method for Film did not return the expected Rating string.");
    }

    @Test
    public void testSetFilmRating(){
        testFilm.setRating("NC-17");
        assertEquals("NC-17", testFilm.getRating(), "setRating method for Film did not set the Rating string to the expected value.");
    }

    @Test
    public void testGetFilmSpecialFeatures(){
        assertEquals("Test Special Features", testFilm.getSpecialFeatures(),"getSpecialFeature method for Film did not return the expected Special Feature string.");
    }

    @Test
    public void testSetFilmSpecialFeatures(){
        testFilm.setSpecialFeatures("SetSpecialFeaturesString");
        assertEquals("SetSpecialFeaturesString", testFilm.getSpecialFeatures(),"setSpecialFeature method for Film did not set the Special Feature string to the expected value.");
    }

    @Test
    public void testGetActorSet(){
        testFilm.setActors(testActorSet);
        assertEquals(testActorSet, testFilm.getActors(), "The getActor method in Films did not get the expected Actor Set value.");
    }

    @Test
    public void testSetActorSet(){
        testActorSet.add (new Actor("Test2","Actor2"));
        testFilm.setActors(testActorSet);
        assertEquals(testActorSet, testFilm.getActors(), "The setActor method in Films did not set the Actor Set to the expected value.");
    }

    @Test
    public void testGetCategorySet(){
        testFilm.setCategory(testCategorySet);
        assertEquals(testCategorySet, testFilm.getCategory(),"The getCategory method in Films did not get the expected Category Set value.");
    }

    @Test
    public void testSetCategorySet(){
        testCategorySet.add (new Category("Test Category Name 2"));
        testFilm.setCategory(testCategorySet);
        assertEquals(testCategorySet, testFilm.getCategory(),"The setCategory method in Films did not set the Category Set to the expected value.");
    }

}

