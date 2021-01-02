package com.jayr.activeusers.Models;

import android.net.Uri;

public class UploadedPhoto {
    private Uri Uri;
    private String Date;

    public android.net.Uri getUri() {
        return Uri;
    }

    public void setUri(android.net.Uri uri) {
        Uri = uri;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "UploadedPhoto{" +
                "Uri=" + Uri +
                ", Date='" + Date + '\'' +
                '}';
    }
}
