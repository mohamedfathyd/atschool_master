package com.atschoolPioneerSchool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class lesson_material extends AppCompatActivity {
    private Toolbar mToolbar;
    private ActionBar actionBar;
    ImageView doucment,img,videos,makesure,exercies,qustions;
    Intent intent;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lesson_material);
        doucment=(ImageView) findViewById(R.id.imageView4);
        img=(ImageView)findViewById(R.id.imageView3);
        videos=(ImageView)findViewById(R.id.imageView8);
        makesure=(ImageView)findViewById(R.id.imageView9);
        exercies=(ImageView)findViewById(R.id.imageView10);
        qustions=(ImageView)findViewById(R.id.imageView11);
        intent=getIntent();
        id=intent.getIntExtra("id",0);
        doucment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(lesson_material.this,lesson_doucment.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(lesson_material.this,lesson_images.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(lesson_material.this,lesson_videos.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        makesure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(lesson_material.this,"Next Step",Toast.LENGTH_LONG).show();
            }
        });
       exercies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(lesson_material.this,"Next Step",Toast.LENGTH_LONG).show();
            }
        });
        qustions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(lesson_material.this,"Next Step",Toast.LENGTH_LONG).show();
            }
        });

        initToolbar();
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
}
