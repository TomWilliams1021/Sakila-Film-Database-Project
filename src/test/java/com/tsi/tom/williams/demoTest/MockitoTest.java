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
        Assertions.assertEquals(expected, actual, "Data was not added into the test database.");
    }

}
