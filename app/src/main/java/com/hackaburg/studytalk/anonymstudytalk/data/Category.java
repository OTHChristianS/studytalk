package com.hackaburg.studytalk.anonymstudytalk.data;

import java.util.ArrayList;

/**
 * Created by Christian Schütze on 16.04.2016.
 */
public class Category<T> {
    private String name;
    private ArrayList<T> subElements;
    private CategoryButtonType type;

    public Category(String name){
        this.name = name;
        this.subElements = new ArrayList<>();
        this.type = CategoryButtonType.STANDARD;
    }

    public Category(String name, CategoryButtonType type){
        this(name);
        this.type = type;
    }

    public CategoryButtonType getType(){
        return getType();
    }

    public boolean add(T element){
        if(this.subElements.contains(element)){
            // Category already exists
            return false;
        } else {
            // create Category
            this.subElements.add(element);

            return true;
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Category){
            Category<T> o2 = (Category) o;

            if(o2.name.equals(this.name)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getName(){
        return this.name;
    }
}
