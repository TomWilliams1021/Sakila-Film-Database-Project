package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.Actor;
import com.tsi.tom.williams.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    private Actor testActor = new Actor("Fake","Actor");
    private Set<Film> testFilm = new HashSet<>();

    @Test
    void testGetActorId(){
        assertEquals(0, testActor.getActorId(), "getActorId method did not return the expected Id value.");
    }

    @Test
    void testGetActorFirstName(){
        assertEquals("Fake", testActor.getFirstName(), "getFirstName method for Actor did not return the expected name string.");
    }

    @Test
    void testSetActorFirstName(){
        testActor.setFirstName("Faker");
        assertEquals("Faker", testActor.getFirstName(), "setFirstName method for Actor did not set the first name correctly.");
    }

    @Test
    void testGetActorLastName(){
        assertEquals("Actor", testActor.getLastName(), "getLastName method for Actor did not return the expected name string.");
    }

    @Test
    void testSetActorLastName(){
        testActor.setLastName("Surname");
        assertEquals("Surname", testActor.getLastName(), "setLastName method for Actor did not set the last name correctly.");
    }

    @Test
    void testSetFilms(){
        testFilm.add (new Film("Test Film", "Test Description", 2006, 1, 90, "PG", "Test Special Features"));
        testActor.setFilms(testFilm);
        assertEquals(testFilm, testActor.getFilms(), "The setFilms method in Actor did not set the film set to the expected value.");
    }

    @Test
    void testGetFilms(){
        testFilm.add (new Film("Test Film", "Test Description", 2006, 1, 90, "PG", "Test Special Features"));
        testActor.setFilms(testFilm);
        assertEquals(testFilm, testActor.getFilms(), "The getFilms method in Actor did not return the expected film set.");
    }
}
