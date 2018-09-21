package com.atschoolPioneerSchool.new_model;

import com.google.gson.annotations.SerializedName;

public class doucment_content {

    @SerializedName("name")
    String NameA;
    @SerializedName("nameA")
    String Name;
    @SerializedName("lessonImageUrl")
    String lessonImageUrl;


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

    public String getlessonImageUrl() {
        return lessonImageUrl;
    }

    public void setlessonImageUrl(String lessonImageUrl) {
        this.lessonImageUrl = lessonImageUrl;
    }
}
