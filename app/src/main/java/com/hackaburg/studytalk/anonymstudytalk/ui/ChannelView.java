package com.hackaburg.studytalk.anonymstudytalk.ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.hackaburg.studytalk.anonymstudytalk.R;
import com.hackaburg.studytalk.anonymstudytalk.data.Category;
import com.hackaburg.studytalk.anonymstudytalk.data.Post;

/**
 * @// TODO: 17.04.2016 Adding Answer functionality
 */
public class ChannelView extends AppCompatActivity {
    private LinearLayout postArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channelview);

        this.postArea = (LinearLayout) findViewById(R.id.posts);

    }

    public void newPost(View view){
        this.getUserInput();
    }

    private boolean publishPost(String text){
        Post post = new Post(text, 1);
        /*Post a1 = new Post("tolle Antwort 1", 2);
        Post a2 = new Post("tollere Antwort", 3);

        post.addAnswer(a1);
        post.addAnswer(a2);*/

        LinearLayout newPostView = this.createView(post);

        this.postArea.addView(newPostView);

        return true;
    }

    private void getUserInput(){
        // Get User Input
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add new Post");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = input.getText().toString();

                publishPost(text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private LinearLayout createView(Post post){
        LinearLayout postWrapper = new LinearLayout(this);
        postWrapper.setOrientation(LinearLayout.VERTICAL);
        //postWrapper.setBackgroundColor(0xFACACAC);

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(0, 0, 0, 40);
        postWrapper.setLayoutParams(llp);
        postWrapper.setPadding(0, 0, 0, 0);

        String t = post.getText();

        TextView view = new TextView(this);
        view.setText(t);
        view.setBackgroundColor(0xF575859);
        view.setTextSize(16);
        postWrapper.addView(view);

        LinearLayout.LayoutParams llpA = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llpA.setMargins(30, 0, 0, 20);

        for(Post answer : post.getAnswers()){
            postWrapper.addView(this.createSeparator());
            TextView answerView = new TextView(this);
            answerView.setText(answer.getText());
            answerView.setBackgroundColor(0xfdcdee0);
            answerView.setLayoutParams(llpA);
            postWrapper.addView(answerView);
        }

        return postWrapper;
    }

    private View createSeparator(){
        View separator = new View(this);
        //separator.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2));
        separator.setMinimumHeight(2);
        separator.setBackgroundColor(0xFCACACA);

        return separator;
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
