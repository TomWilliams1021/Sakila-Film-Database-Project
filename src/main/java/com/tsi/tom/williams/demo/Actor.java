package com.tsi.tom.williams.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "actor")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    private String first_name;
    private String last_name;

    //Maping the many to many relationship between Film and Actor into Film.
    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> films = new HashSet<>();

    public Actor(String firstName, String lastName){
        this.first_name = firstName;
        this.last_name = lastName;
    }

    public Actor(){

    }

    public int getActorId() {
        return actor_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
