package com.example.flickrclient.model;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

import java.io.InputStream;
import java.net.URL;

public class Photo {

    @SerializedName("id")
    String id;
    @SerializedName("owner")
    String owner;
    @SerializedName("secret")
    String secret;
    @SerializedName("server")
    String server;
    @SerializedName("farm")
    String farm;
    @SerializedName("title")
    String title;
    @SerializedName("isfriend")
    String isfriend;
    @SerializedName("isfamily")
    String isfamily;

    public Photo() {
    }

    public Photo(String id, String owner, String secret, String server, String farm, String title, String isfriend, String isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily;
    }

    public String createURL() {
        String url = "https://farm" + this.farm + ".staticflickr.com/" + this.server + "/" + this.id + "_" + this.secret + "_b.jpg";
        return url;
    }

}
