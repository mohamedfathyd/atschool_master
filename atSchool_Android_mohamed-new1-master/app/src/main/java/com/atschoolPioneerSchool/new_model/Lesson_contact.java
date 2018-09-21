package com.atschoolPioneerSchool.new_model;

import com.google.gson.annotations.SerializedName;

public class Lesson_contact {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String NameA;
    @SerializedName("nameA")
    String Name;
    @SerializedName("lessonImage")
    String lessonImage;


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

    public String getlessonImage() {
        return lessonImage;
    }

    public void setlessonImage(String lessonImage) {
        this.lessonImage = lessonImage;
    }
}
