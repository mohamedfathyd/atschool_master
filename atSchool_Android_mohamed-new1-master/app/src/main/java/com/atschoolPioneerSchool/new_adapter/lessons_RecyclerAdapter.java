package com.atschoolPioneerSchool.new_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atschoolPioneerSchool.R;
import com.atschoolPioneerSchool.lesson_material;
import com.atschoolPioneerSchool.new_model.Lesson_contact;
import com.bumptech.glide.Glide;

import java.util.List;

public class lessons_RecyclerAdapter extends RecyclerView.Adapter<lessons_RecyclerAdapter.MyViewHolder> {

    private Context context;
    List<Lesson_contact> contactslist;
    private int i = 0;
    String _switchLang;
    public lessons_RecyclerAdapter(Context context, List<Lesson_contact> contactslist) {
        this.contactslist = contactslist;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_lessons_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        _switchLang= context.getResources().getConfiguration().locale.getLanguage();

        if(_switchLang.equals("ar")||contactslist.get(position).getName().equals("")) {
            holder.sub_Name.setText(contactslist.get(position).getNameA());
        }
        else{
            holder.sub_Name.setText(contactslist.get(position).getName());
        }
        //    holder.num_douc.setText(contactslist.get(position).);
        if(contactslist.get(position).getlessonImage()==null){
            Glide.with(context).load(R.drawable.lesson_icon).into(holder.image);
        }
        else{
            Glide.with(context).load(contactslist.get(position).getlessonImage()).into(holder.image);}
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id =contactslist.get(position).getId();
                Intent intent=new Intent(context,lesson_material.class);
                intent.putExtra("id",id);
                context.startActivity(intent);

            }


        });
    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sub_Name,num_douc;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            sub_Name=(TextView)itemView.findViewById(R.id.txt_lesson_title);
            num_douc=(TextView)itemView.findViewById(R.id.txt_document_num);
            image=(ImageView)itemView.findViewById(R.id.imageView3);

        }
    }}