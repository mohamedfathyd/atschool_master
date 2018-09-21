package com.atschoolPioneerSchool.new_model;

import com.google.gson.annotations.SerializedName;

public class videos_content {
    @SerializedName("title")
    String title;
    @SerializedName("titleA")
    String titleA;
    @SerializedName("fileUrl")
    String fileUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleA() {
        return titleA;
    }

    public void setTitleA(String titleA) {
        this.titleA = titleA;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
