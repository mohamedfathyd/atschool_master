package com.atschoolPioneerSchool.new_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface_new {
    @GET("/api/lms/GetSubjectByStudentID/")
    Call<List<subject_content>> getcontacts(@Query("sCHStudentID") int sCHStudentID);
    @GET("/api/lms/GetSemetsersBySubjectID/")
    Call<List<semester_content>> getcontacts_semester(@Query("subjectID") int subjectID);
    @GET("/api/lms/GetChapterBySemetserID/")
    Call<List<chapter_content>> getcontacts_chapter(@Query("SemetserID") int SemetserID);
    @GET("/api/lms/GetLessonByChapterID/")
    Call<List<Lesson_contact>> getcontacts_lesson(@Query("ChapterID") int ChapterID);
    @GET("/api/lms/lesson_document/")
    Call<List<doucment_content>> getcontacts_lesson_Doucment(@Query("lessonId") int lessonId);
    @GET("/api/lms/lesson_images/")
    Call<List<images_content>> getcontacts_lesson_images(@Query("lessonId") int lessonId);
    @GET("/api/lms/lesson_videos/")
    Call<List<videos_content>> getcontacts_lesson_videos(@Query("lessonId") int lessonId);
}
