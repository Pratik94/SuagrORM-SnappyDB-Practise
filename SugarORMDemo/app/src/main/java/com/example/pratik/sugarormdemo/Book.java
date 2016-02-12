package com.example.pratik.sugarormdemo;

import com.orm.SugarRecord;

/**
 * Created by pratik on 11/02/16.
 */
public class Book extends SugarRecord {
    String title;
    String edition;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
}
