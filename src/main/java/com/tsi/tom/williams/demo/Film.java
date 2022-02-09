package com.tsi.tom.williams.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Film {

    @Id
    @GeneratedValue
    private int film_id;

    private String title;
    private String description;
    private int language_id;
    private int length;
    private String rating;
    //private double replacement_cost;  May need to be added if you decide to do sales.
    private String special_features;

    public Film(String title, String description, int language_id, int length, String rating, String special_features){
        this.title = title;
        this.description = description;
        this.language_id = language_id;
        this.length = length;
        this.rating = rating;
        this.special_features = special_features;
    }

    public Film(){
    }

    public int getFilm_id() {
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

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
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

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }
}
