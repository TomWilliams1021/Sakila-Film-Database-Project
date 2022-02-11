package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) //Inheriting characteristics needed to use mockito.
public class MockitoTest {
    private SakilaDatabaseApplication sakilaDatabaseApplication;
    @Mock
    private LanguageRepository languageRepository;  //Creating a fake version of the language repo for testing.
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;


    @BeforeEach //Creating an instance of our DB with no data.
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository,
                actorRepository,
                categoryRepository,
                filmRepository);
    }

    @Test
    public void testAddLanguage(){
        Language saveLanguage = new Language("testLanguage");   //Post "testLanguage" as new language into mock DB.
        String expected = "Saved";  //Expected response when a language is added.
        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);   //Since the fake DB doesn't actually exist, this will hold the data for the duration of the test.
        verify(languageRepository).save(languageArgumentCaptor.capture());  //Saving test data to the argument captor.
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data was not added into the Language test database.");
    }

    @Test
    public void testAddFilm(){
        Film saveFilm = new Film("Test Film", "Test Description", 2006, 1, 90, "PG", "Test Special Features");
        String expected = "Saved";
        String actual = sakilaDatabaseApplication.addFilm(saveFilm.getTitle(), saveFilm.getDescription(),saveFilm.getRelease_year(),saveFilm.getLanguageId(), saveFilm.getLength(), saveFilm.getRating(), saveFilm.getSpecialFeatures());
        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data was not added into the Film test database.");

    }

    @Test
    public void testAddCategory(){
        Category saveCategory = new Category(("Test Category"));
        String expected = "Saved";
        String actual = sakilaDatabaseApplication.addCategory(saveCategory.getName());
        ArgumentCaptor<Category>categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data was not added into the Category test database.");
    }

    @Test
    public void testAddActor(){
        Actor saveActor = new Actor("Test","Actor");
        String expected = "Saved";
        String actual = sakilaDatabaseApplication.addActor(saveActor.getFirstName(), saveActor.getLastName());
        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data was not added into the Actor test database.");
    }

}
