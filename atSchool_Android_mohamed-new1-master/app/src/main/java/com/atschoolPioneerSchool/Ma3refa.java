package com.atschoolPioneerSchool;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;

import com.atschoolPioneerSchool.adapter.Ma3refa_viewPager_adapter;

public class Ma3refa extends AppCompatActivity {
    private Toolbar mToolbar;
    private ActionBar actionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ma3refa);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);
        Ma3refa_viewPager_adapter ma3refa_viewPager_adapter=new Ma3refa_viewPager_adapter(getSupportFragmentManager());
        //add fragments
        ma3refa_viewPager_adapter.AddFragment(new Fragment_subjects(),getString(R.string.subjects));
        ma3refa_viewPager_adapter.AddFragment(new Fragment_exams(),getString(R.string.Exams));
        //setup adapter
        viewPager.setAdapter(ma3refa_viewPager_adapter);
        tabLayout.setupWithViewPager(viewPager);
        initToolbar();
     //   BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomnav);
     //   navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
  /*  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            switch (item.getItemId()) {
                case R.id.call_sun_btn:
                    Toast.makeText(Ma3refa.this,"call",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.home_btn:
                    Toast.makeText(Ma3refa.this,"home",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.location_btn:
                    Toast.makeText(Ma3refa.this,"location",Toast.LENGTH_LONG).show();
                    return true;

            }
            return false;
        }
    };*/
}
