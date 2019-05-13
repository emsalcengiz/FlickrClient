package com.example.flickrclient.model;

import com.google.gson.annotations.SerializedName;

public class Flicker {
    @SerializedName("photos")
    FlickerPhotos photos;
    @SerializedName("stat")
    String stat;

    public Flicker() {
    }

    public Flicker(FlickerPhotos photos, String stat) {
        this.photos = photos;
        this.stat = stat;
    }

    public FlickerPhotos getPhotos() {
        return photos;
    }

    public void setPhotos(FlickerPhotos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
