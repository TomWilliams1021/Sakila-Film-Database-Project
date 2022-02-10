package com.tsi.tom.williams.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;

    private String name;


    public Language(String name){
        this.name = name;
    }

    public Language(){}

    public int getLanguageId() {
        return language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
