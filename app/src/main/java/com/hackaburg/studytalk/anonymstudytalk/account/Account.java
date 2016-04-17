package com.hackaburg.studytalk.anonymstudytalk.account;

/**
 * Created by Christian Schütze on 16.04.2016.
 */
public class Account {
    private String name;
    private final int id;
    private static int idCounter = 0;

    public Account(String name){
        this.name = name;
        this.id = Account.idCounter;

        Account.idCounter++;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
}
