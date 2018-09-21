package com.atschoolPioneerSchool.new_model;

import com.google.gson.annotations.SerializedName;

public class chapter_content {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String NameA;
    @SerializedName("nameA")
    String Name;
    @SerializedName("ChapterImage")
    String ChapterImage;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameA() {
        return NameA;
    }
    public void setNameA(String nameA) {
        NameA = nameA;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getChapterImage() {
        return ChapterImage;
    }
    public void setChapterImage(String ChapterImage) {
        this.ChapterImage =ChapterImage;
    }
}


