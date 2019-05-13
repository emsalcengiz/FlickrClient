package com.example.flickrclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlickerPhotos {

    @SerializedName("page")
    Integer page;
    @SerializedName("pages")
    Integer pages;
    @SerializedName("perpage")
    Integer perpage;
    @SerializedName("total")
    Integer total;
    @SerializedName("photo")
    List<Photo> photo;

    public FlickerPhotos() {
    }

    public FlickerPhotos(Integer page, Integer pages, Integer perpage, Integer total, List<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
