package com.hackaburg.studytalk.anonymstudytalk.data;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Christian Schütze on 16.04.2016.
 */
public class Post {
    private final int id;
    private String text;
    private final int owner;
    private Date creationDate;
    private ArrayList<Post> answers;

    private static int idCounter = 0;

    public Post(String text, int accId){
        this.text = text;
        this.owner = accId;
        this.id = idCounter;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();

        Post.idCounter++;
    }

    public void addAnswer(Post post){
        this.answers.add(post);
    }

    public String getText(){
        return this.text;
    }

    public Date getCreationDate(){
        return this.creationDate;
    }

    public ArrayList<Post> getAnswers(){
        return this.answers;
    }
}
