package com.atschoolPioneerSchool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.atschoolPioneerSchool.new_adapter.subject_RecyclerAdapter;
import com.atschoolPioneerSchool.new_model.ApIclient;
import com.atschoolPioneerSchool.new_model.Apiinterface_new;
import com.atschoolPioneerSchool.new_model.subject_content;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_subjects extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private subject_RecyclerAdapter recyclerAdapter;
    private List<subject_content> contactList;
    private Apiinterface_new apiinterface;
    View view;
    ProgressBar progressBar;
    public Fragment_subjects() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subjects, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    return view;
    }

    public void fetchInfo(){
        apiinterface= ApIclient.getapiClient().create(Apiinterface_new.class);
        Call<List<subject_content>> call = apiinterface.getcontacts(40991);
        call.enqueue(new Callback<List<subject_content>>() {
            @Override
            public void onResponse(Call<List<subject_content>> call, Response<List<subject_content>> response) {
                if(response.body()==null){
                    Toast.makeText(getContext(), "empty", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
                else {
                    contactList = response.body();
                    progressBar.setVisibility(View.GONE);
                    recyclerAdapter=new subject_RecyclerAdapter(getContext(),contactList);
                    recyclerView.setAdapter(recyclerAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<subject_content>> call, Throwable t) {

            }
        });
    }
}
