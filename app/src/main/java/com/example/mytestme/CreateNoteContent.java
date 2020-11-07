package com.example.mytestme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreateNoteContent extends AppCompatActivity {

    private EditText editTextName,editTextNumber,editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note_content);
        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content,menu);
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
        String name = editTextName.getText().toString();
        String number = editTextNumber.getText().toString();
        String email = editTextEmail.getText().toString();
        Intent intent = new Intent(CreateNoteContent.this,MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        intent.putExtra("email",email);
        setResult(RESULT_FIRST_USER,intent);
        finish();
    }

}