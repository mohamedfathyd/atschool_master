package com.atschoolPioneerSchool.new_model;

import com.google.gson.annotations.SerializedName;

public class semester_content {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("nameA")
    String nameA;
    @SerializedName("semesterImage")
    String semesterImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getSemesterImage() {
        return semesterImage;
    }

    public void setSemesterImage(String semesterImage) {
        this.semesterImage = semesterImage;
    }
}
