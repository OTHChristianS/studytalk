package com.hackaburg.studytalk.anonymstudytalk.data;

import java.util.ArrayList;

/**
 * Created by Christian Schütze on 16.04.2016.
 *
 * With STRUCTURE_CHANNEL it will only be allowed to create subchannels for structure reasons.
 * With GROUND_CHANNEL it will only be allowed to create posts.
 */
public class Channel {
    private ArrayList<Post> posts;
    private String name;
    private String prof;
    private int owner; // int since it will be later an Database int ID - 0 = Root user
    private String description;
    private int semester;

    /**
     * Create a CategoryView.
     *
     * @param name The CategoryView name
     * @param description The CategoryView description
     * @param prof The Professor of the course
     * @param semester The semester the course is taking place.
     *                 Coded like the following:
     *                 SS15 = 15
     *                 WS15/16 = 1516
     *                 SS16 = 16
     * @param owner The CategoryView creator.
     */
    public Channel(String name, String description, String prof, int semester, int owner){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.prof = prof;
        this.semester = semester;
    }

    /**
     * Post something new to the channel.
     *
     * @// TODO: 16.04.2016 Implementing
     * @param text The post's text.
     * @param owner The poster's ID.
     * @return True on success, False otherwise.
     */
    public boolean post(String text, int owner){
        return true;
    }

    public String getName(){
        return this.name;
    }
}
