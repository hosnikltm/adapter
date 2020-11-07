package com.example.mytestme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNote extends AppCompatActivity {

    private boolean mIsViewingOrUpdating; //state of the activity
    private long mNoteCreationTime;
    private String mFileName;
    private Note mLoadedNote = null;
    private Item item;

    private EditText editTextTitle, editTextSubTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        editTextTitle = findViewById(R.id.editTextTitleNote);
        editTextSubTitle = findViewById(R.id.editTextSubTitleNote);

        //check if view/edit note bundle is set, otherwise user wants to create new note
        mFileName = getIntent().getStringExtra(Utilities.EXTRAS_NOTE_FILENAME);
        if(mFileName != null && !mFileName.isEmpty() && mFileName.endsWith(Utilities.FILE_EXTENSION)) {
            item = Utilities.getNoteByFileName(getApplicationContext(), mFileName);
            if (mLoadedNote != null) {
                //update the widgets from the loaded note
               editTextTitle.setText(mLoadedNote.getTitle());
                editTextSubTitle.setText(mLoadedNote.getSubTitle());
                mNoteCreationTime = item.getDateTime();
                mIsViewingOrUpdating = true;
            }
        } else { //user wants to create a new note
            mNoteCreationTime = System.currentTimeMillis();
            mIsViewingOrUpdating = false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.action_save: //or update :P
                save();
                break;

            case R.id.action_back:
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    private void save(){
        String title = editTextTitle.getText().toString();
        String subTitle = editTextSubTitle.getText().toString();
        //see if user has entered anything :D lol
        if(title.isEmpty()) { //title
            Toast.makeText(CreateNote.this, "please enter a title!"
                    , Toast.LENGTH_SHORT).show();
            return;
        }

        if(subTitle.isEmpty()) { //content
            Toast.makeText(CreateNote.this, "please enter a content for your note!"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        //set the creation time, if new note, now, otherwise the loaded note's creation time
        if(item != null) {
            mNoteCreationTime = item.getDateTime();
        } else {
            mNoteCreationTime = System.currentTimeMillis();
        }
        if (Utilities.saveNote(this,new Item(mNoteCreationTime,0,new Note(title,subTitle)))){
            Toast.makeText(this, "note has been saved", Toast.LENGTH_SHORT).show();
        } else { //failed to save the note! but this should not really happen :P :D :|
            Toast.makeText(this, "can not save the note. make sure you have enough space " +
                    "on your device", Toast.LENGTH_SHORT).show();
        }
        finish();

    }
}