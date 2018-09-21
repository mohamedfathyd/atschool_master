package com.atschoolPioneerSchool.new_adapter;

import android.app.Dialog;
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
import com.atschoolPioneerSchool.new_model.videos_content;
import com.atschoolPioneerSchool.show_video_new;
import com.bumptech.glide.Glide;

import java.util.List;

public class lesson_videos_RecyclerAdapter extends RecyclerView.Adapter<lesson_videos_RecyclerAdapter.MyViewHolder> {

    private Context context;
    List<videos_content> contactslist;
    private int i = 0;
    Dialog dialog;
    String _switchLang;
    String Videourl ;
    public lesson_videos_RecyclerAdapter(Context context, List<videos_content> contactslist) {
        this.contactslist = contactslist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_videos_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        _switchLang= context.getResources().getConfiguration().locale.getLanguage();

        if(_switchLang.equals("ar")) {
            holder.sub_Name.setText(contactslist.get(position).getTitleA());
        }
        else{
            holder.sub_Name.setText(contactslist.get(position).getTitle());
        }
        //    holder.num_douc.setText(contactslist.get(position).);
        Glide.with(context).load(R.drawable.videos_icon).into(holder.image);
         Videourl=contactslist.get(position).getFileUrl();
       // Glide.with(context).load(contactslist.get(position).getList().getFileUrl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,show_video_new.class));
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
            sub_Name=(TextView)itemView.findViewById(R.id.txt_video_title);
            image=(ImageView)itemView.findViewById(R.id.imageView3);

        }
    }}