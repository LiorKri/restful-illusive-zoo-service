package com.illusivezoo.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Animal implements Identifiable {
    private Long id;
    private String name;
    private String species;
    private LocalDateTime lastMealTime;
    private LocalDateTime lastCleaningTime;
    private boolean isSleep;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies(){
        return species;
    }

    public void setLastMealTime(LocalDateTime lastMealTime){
        this.lastMealTime = lastMealTime;
    }

    public LocalDateTime getLastMealTime(){
        return lastMealTime;
    }

    public void setLastCleaningTime(LocalDateTime lastCleaningTime){
        this.lastCleaningTime = lastCleaningTime;
    }

    public LocalDateTime getLastCleaningTime(){
        return lastCleaningTime;
    }

    public void setIsSleep(boolean isSleep){
        this.isSleep = isSleep;
    }

    public boolean getIsSleep(){
        return isSleep;
    }
}
