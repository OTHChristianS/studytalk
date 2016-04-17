package com.hackaburg.studytalk.anonymstudytalk.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.hackaburg.studytalk.anonymstudytalk.R;
import com.hackaburg.studytalk.anonymstudytalk.data.Category;
import com.hackaburg.studytalk.anonymstudytalk.data.Post;

public class ChannelView extends AppCompatActivity {
    LinearLayout postArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channelview);

        this.postArea = (LinearLayout) findViewById(R.id.posts);

    }

    public boolean newPost(View view){
        Post post = new Post("das ist ein test", 1);
        Post a1 = new Post("tolle Antwort 1", 2);
        Post a2 = new Post("tollere Antwort", 3);

        post.addAnswer(a1);
        post.addAnswer(a2);

        LinearLayout newPostView = this.createView(post);

        this.postArea.addView(newPostView);

        return true;
    }

    private LinearLayout createView(Post post){
        LinearLayout postWrapper = new LinearLayout(this);
        postWrapper.setOrientation(LinearLayout.VERTICAL);
        postWrapper.setPadding(0, 0, 0, 20);
        postWrapper.setBackgroundColor(0xFACACAC);
        postWrapper.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        String t = post.getText();

        TextView view = new TextView(this);
        view.setText(t);
        view.setBackgroundColor(0xE5EBF1);
        postWrapper.addView(view);

        for(Post answer : post.getAnswers()){
            TextView answerView = new TextView(this);
            answerView.setText(answer.getText());
            answerView.setBackgroundColor(0xF575859);
            answerView.setPadding(20, 30, 0, 0);
            postWrapper.addView(answerView);
        }

        return postWrapper;
    }

    /**
     * Removes the old posts and adds it to the top again with the answer.
     *
     * @param postId The ID of the post
     * @return True on success, False otherwise
     */
    public boolean answer(int postId){


        return true;
    }
}
