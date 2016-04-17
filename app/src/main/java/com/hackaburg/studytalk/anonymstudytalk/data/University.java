package com.hackaburg.studytalk.anonymstudytalk.data;

import java.util.ArrayList;

/**
 * Created by Christian Schütze on 16.04.2016.
 */
public class University {
    private final String name;
    private final int id;
    private String address;
    private final ArrayList<Category> categories;

    private static int idCounter;

    public University(String name){
        this.name = name;
        this.id = University.idCounter;
        this.categories = new ArrayList<>();

        University.idCounter++;
    }

    public University(String name, String addr){
        this(name);
        this.address = addr;
    }

    public ArrayList<Category> getCategories(){
        return this.categories;
    }

    public void addCategory(Category c){
        this.categories.add(c);
    }

    public String getName(){
        return this.name;
    }

    /**
     * @// TODO: 16.04.2016 Implementing 
     * @return
     */
    private boolean createUniversity(){
        return true;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
