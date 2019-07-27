package com.example.officecrimes;

import java.util.Date;
import java.util.UUID;

public class Crime {

    //UUID generates universally unique ID values
    private UUID id;
    private String title;
    private Date date;
    private boolean solved;

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    //Create a getter method to get the file name of the photo
    public String getPhotoFileName(){
        return "IMG_"+getId().toString()+" .jpg";
    }

    private String suspect;

    public Crime(){
        this(UUID.randomUUID());
        /*id = UUID.randomUUID();
        date = new Date()*/;
    }

    public Crime(UUID id){
        this.id = id;
        date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
