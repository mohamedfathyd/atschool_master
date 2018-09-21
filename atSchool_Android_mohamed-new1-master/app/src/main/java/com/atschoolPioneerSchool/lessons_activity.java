package com.atschoolPioneerSchool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.atschoolPioneerSchool.new_adapter.lessons_RecyclerAdapter;
import com.atschoolPioneerSchool.new_model.ApIclient;
import com.atschoolPioneerSchool.new_model.Apiinterface_new;
import com.atschoolPioneerSchool.new_model.Lesson_contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lessons_activity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ActionBar actionBar;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private lessons_RecyclerAdapter recyclerAdapter;
    private List<Lesson_contact> contactList;
    private Apiinterface_new apiinterface;
    Intent intent;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lessons_activity);
        progressBar=(ProgressBar)findViewById(R.id.progressBar_subject);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        intent=getIntent();
        id=intent.getIntExtra("id",0);
        initToolbar();
        fetchInfo();
    }
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void fetchInfo(){
       apiinterface= ApIclient.getapiClient().create(Apiinterface_new.class);
        Call<List<Lesson_contact>> call = apiinterface.getcontacts_lesson(id);
        call.enqueue(new Callback<List<Lesson_contact>>() {
            @Override
            public void onResponse(Call<List<Lesson_contact>> call, Response<List<Lesson_contact>> response) {
                if(response.body()==null){
                    Toast.makeText(lessons_activity.this, "empty", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
                else {

                    contactList = response.body();
                    progressBar.setVisibility(View.GONE);
                    recyclerAdapter=new lessons_RecyclerAdapter(lessons_activity.this,contactList);
                    recyclerView.setAdapter(recyclerAdapter);
                }


            }

            @Override
            public void onFailure(Call<List<Lesson_contact>> call, Throwable t) {

            }
        });
    }
}
