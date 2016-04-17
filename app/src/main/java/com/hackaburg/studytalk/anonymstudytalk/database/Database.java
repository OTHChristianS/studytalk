package com.hackaburg.studytalk.anonymstudytalk.database;

import com.hackaburg.studytalk.anonymstudytalk.data.Category;
import com.hackaburg.studytalk.anonymstudytalk.data.CategoryButtonType;
import com.hackaburg.studytalk.anonymstudytalk.data.Channel;
import com.hackaburg.studytalk.anonymstudytalk.data.ChannelType;
import com.hackaburg.studytalk.anonymstudytalk.data.University;

import java.util.ArrayList;


/**
 * Created by Christian Schütze on 16.04.2016.
 */
public class Database {
    private ArrayList<University> universities;

    public Database(){
        this.universities = new ArrayList<>();
        this.generateData();
    }

    public ArrayList<University> getUniversities(){
        return this.universities;
    }

    /**
     * Find an university by it's name and return it's Object.
     *
     * @param name The searched String
     * @return The University object or null if the university doesn't exists.
     */
    public University findUniversity(String name){
        for(University u : this.universities){
            if(u.getName().equals(name)){
                return u;
            }
        }

        return null;
    }

    /**
     * Generate some data to test the app with
     */
    private void generateData(){
        // create universities
        University othR = new University("OTH Regensburg");
        University uniR = new University("Universität Regensburg");
        University othAW = new University("OTH Amberg/Weiden");

        // add subcategories to the universities
        // OTH Regensburg
        othR.addCategory(new Category<Channel>("Faculty", CategoryButtonType.BLUE));
        othR.addCategory(new Category<Channel>("Career", CategoryButtonType.GREEN));
        othR.addCategory(new Category<Channel>("Info", CategoryButtonType.YELLOW));
        othR.addCategory(new Category<Channel>("Groups", CategoryButtonType.PINK));


        // add channels to the categories


        // add universities to the list
        this.universities.add(othR);
        this.universities.add(uniR);
        this.universities.add(othAW);


        // generate channels
        othR.getCategories().get(0).add(new Channel("Programmieren I", "Programmieren lernen so", "Prof.Dr. Jobst", 16, 0));

    }
}
