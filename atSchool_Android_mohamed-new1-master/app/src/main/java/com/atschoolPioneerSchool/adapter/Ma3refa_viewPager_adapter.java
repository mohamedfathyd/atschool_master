package com.atschoolPioneerSchool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Ma3refa_viewPager_adapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragmentList_Title=new ArrayList<>();


    public Ma3refa_viewPager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList_Title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList_Title.get(position);
    }
    public void AddFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentList_Title.add(title);
    }
}
