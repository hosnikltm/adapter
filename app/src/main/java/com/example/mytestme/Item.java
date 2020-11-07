package com.example.mytestme;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Item {
    private int type;
    private Object object;
    private long dateTime;

    public Item(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public Item(long dateTime,Object object) {
        this.dateTime = dateTime;
        this.object = object;
    }

    public Item(long dateTime,int type, Object object) {
        this.dateTime = dateTime;
        this.type = type;
        this.object = object;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateTimeFormatted(Context context) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"
                , context.getResources().getConfiguration().locale);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(new Date(dateTime));
    }
}
