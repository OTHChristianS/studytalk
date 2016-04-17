package com.hackaburg.studytalk.anonymstudytalk.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.hackaburg.studytalk.anonymstudytalk.R;
import com.hackaburg.studytalk.anonymstudytalk.data.Category;
import com.hackaburg.studytalk.anonymstudytalk.data.CategoryButtonType;
import com.hackaburg.studytalk.anonymstudytalk.data.University;
import com.hackaburg.studytalk.anonymstudytalk.database.Database;

import java.util.ArrayList;

public class CategoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryview);

        LinearLayout ll = (LinearLayout) findViewById(R.id.categoryButtonContainer);

        ArrayList<Category> categories = new Database().getUniversities().get(0).getCategories();

        System.out.println(categories.size());

        for(Category c: categories){
            Button b = new Button(this);
            b.setText(c.getName());
            b.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            /*
            if(c.getType() != CategoryButtonType.STANDARD){
                if(c.getType() == CategoryButtonType.BLUE){
                    b.setBackgroundColor(0xF007DFE);
                } else if(c.getType() == CategoryButtonType.YELLOW){
                    b.setBackgroundColor(0xFEFE82C);
                } else if(c.getType() == CategoryButtonType.GREEN){
                    b.setBackgroundColor(0xF3AEF2C);
                } else if(c.getType() == CategoryButtonType.PINK){
                    b.setBackgroundColor(0xFFE00E3);
                }
            }*/

            // set category so it can be accessed in the inner class
            final Category cat = c;

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Remember clicked button
                    ViewData.data = cat;

                    next(v);
                }
            });

            ll.addView(b);
        }
    }

    public void next(View v){
        Intent myIntent = new Intent(this, ChannelView.class);
        startActivity(myIntent);
    }
}
