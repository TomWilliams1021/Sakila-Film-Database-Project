package com.tsi.tom.williams.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int length;
    private String rating;
    private String special_features;

    //Maping the many to many relationship between Film and Actor into Film.
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    @JoinTable(name = "film_actor",
            joinColumns = {
                @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                    nullable = false, updatable = false)})
    private Set<Actor> actors = new HashSet<>();

    //Maping the many to many relationship between Film and Category into Film.
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name =  "film_category",
            joinColumns = {
                @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "category_id", referencedColumnName = "category_id",
                    nullable = false, updatable = false)})
    private Set<Category> category = new HashSet<>();

    public Film(String title, String description, int releaseYear, int languageId, int length, String rating, String specialFeatures){
        this.title = title;
        this.description = description;
        this.release_year = releaseYear;
        this.language_id = languageId;
        this.length = length;
        this.rating = rating;
        this.special_features = specialFeatures;
    }


    public Film(){
    }

    public int getFilmId() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int releaseYear) {
        this.release_year = releaseYear;
    }

    public int getLanguageId() {
        return language_id;
    }

    public void setLanguageId(int languageId) {
        this.language_id = languageId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return special_features;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.special_features = specialFeatures;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
