package com.example.pratik.sugarormdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.Arrays;

public class SnappyDB extends AppCompatActivity {

    private Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snappy_db);

        try {
            DB snappydb = DBFactory.open(this);

            String name = snappydb.get("name");
            int age = snappydb.getInt("age");
            boolean single = snappydb.getBoolean("single");
            String[] books = snappydb.getArray("books", String.class);// get array of string

            status = snappydb.getObject("status",Status.class);

            Toast.makeText(SnappyDB.this, "name -- "+name +"\n age-- "+age+"\nsingle-- "+single+"\nbooks -- "+ Arrays.toString(books) +"\n Status--- \n message-- "+status.getMessage()+"\n status -- "+status.getStatus(), Toast.LENGTH_SHORT).show();
        }
        catch (SnappydbException e){

        }

    }
}
