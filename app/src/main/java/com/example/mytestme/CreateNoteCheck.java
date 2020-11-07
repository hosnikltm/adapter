package com.example.mytestme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreateNoteCheck extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note_check);
        editText = findViewById(R.id.editTextCheck);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check,menu);
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
        String name = editText.getText().toString();

        Intent intent = new Intent(CreateNoteCheck.this,MainActivity.class);
        intent.putExtra("check",name);
        setResult(33,intent);
        finish();
    }

}