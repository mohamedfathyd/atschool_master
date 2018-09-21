package com.atschoolPioneerSchool.new_model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApIclient {
    private static final String url="http://api.egyptschools.org/";
    private static Retrofit retrofit =null;
    public static Retrofit getapiClient(){
        if(retrofit== null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
