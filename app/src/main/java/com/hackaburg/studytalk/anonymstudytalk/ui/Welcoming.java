package com.hackaburg.studytalk.anonymstudytalk.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackaburg.studytalk.anonymstudytalk.R;
import com.hackaburg.studytalk.anonymstudytalk.data.University;
import com.hackaburg.studytalk.anonymstudytalk.database.Database;

import java.util.ArrayList;

public class Welcoming extends AppCompatActivity {
    public AutoCompleteTextView chooser;
    public TextView title;
    public TextView chooserTitle;
    public ImageView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming);

        // Title
        this.title = (TextView) findViewById(R.id.welcomingTitle);

        // Choose Bar Title
        this.chooserTitle = (TextView) findViewById(R.id.welcomingChooseTitle);

        // submit Button
        this.submit = (ImageView) findViewById(R.id.welcomingSubmit);

        // university chooser
        this.chooser = (AutoCompleteTextView) findViewById(R.id.welcomingUniversityChooser);

        ArrayList<University> unis = new Database().getUniversities();
        String[] unisStrings = new String[unis.size()];

        int i = 0;

        for(University u : unis){
            unisStrings[i] = u.getName();
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, unisStrings);

        this.chooser.setThreshold(1);//will start working from first character
        this.chooser.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
    }

    public void changeToCategoriesActivity(View view){
        String uniString = this.chooser.getText().toString();

        if(uniString.isEmpty()){
            this.displayMissingSelectionMessage();

            return;
        }

        University uni = new Database().findUniversity(uniString);

        if(uni == null){
            // University not found
            this.displayMissingSelectionMessage();

            return;
        }

        // Remember selected university
        ViewData.university = uni;

        // Change Activity
        Intent myIntent = new Intent(this, CategoryView.class);
        startActivity(myIntent);
    }

    private void displayMissingSelectionMessage(){

    }
}
