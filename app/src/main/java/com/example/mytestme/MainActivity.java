package com.example.mytestme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int Result_Cote_Note = 111;
    private static final int Result_Cote_Content = 222;
    private static final int Result_Cote_Check = 333;

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_items, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.save: //or update :P
                noteItem();
                break;

            case R.id.content:
                contentItem();
                break;
            case R.id.checkBox_menu:
                checkItem();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void noteItem() {
        Intent intent = new Intent(this, CreateNote.class);
        startActivity(intent);
    }

    private void contentItem() {
        Intent intent = new Intent(this, CreateNoteContent.class);
        startActivity(intent);
    }

    private void checkItem() {
        Intent intent = new Intent(this, CreateNoteCheck.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //load saved notes into the recyclerView
        //first, reset the recyclerView
        recyclerView.setAdapter(null);
        ArrayList<Item> notes = Utilities.getAllSavedNotes(getApplicationContext());

        //sort notes from new to old


        if (notes != null && notes.size() > 0) { //check if we have any notes!
            final MyAdapter na = new MyAdapter(notes);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            na.notifyDataSetChanged();
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(na);
        }
    }
}