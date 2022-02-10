package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class menuCucumberStepsDeaf {

    private SakilaDatabaseApplication sakilaDBApp;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void setup() {
        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        filmRepository = mock(FilmRepository.class);

        sakilaDBApp = new SakilaDatabaseApplication(languageRepository, actorRepository, categoryRepository, filmRepository);
    }

    Language storedLanguage;
    String actualResult;
    @Given("We have a language entry to add")
    public void we_have_a_language_entry_to_add() {
        setup();
        storedLanguage = new Language("Language Test");
    }
    @When("We add the language entry")
    public void we_add_the_language_entry() {
        actualResult = sakilaDBApp.addLanguage(storedLanguage.getName());
    }
    @Then("The language should be added and we should return that the new language was saved")
    public void The_language_should_be_added() {
        String expectedResult = "Saved";
        Assertions.assertEquals(expectedResult, actualResult, "Save new language failed.");

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
    }

}
