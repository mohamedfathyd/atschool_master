package com.atschoolPioneerSchool.new_adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atschoolPioneerSchool.R;
import com.atschoolPioneerSchool.new_model.images_content;
import com.bumptech.glide.Glide;

import java.util.List;

public class lesson_images_RecyclerAdapter extends RecyclerView.Adapter<lesson_images_RecyclerAdapter.MyViewHolder> {

    private Context context;
    List<images_content> contactslist;
    private int i = 0;
    String _switchLang;
    Dialog dialog;
    public lesson_images_RecyclerAdapter(Context context, List<images_content> contactslist) {
        this.contactslist = contactslist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_images_list, parent, false);

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
        Glide.with(context).load(contactslist.get(position).getFileUrl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog=new Dialog(context);
                dialog.setContentView(R.layout.custoum_dialog);
                dialog.show();
                ImageView imageView = (ImageView) dialog.findViewById(R.id.dialogimg);
                Glide.with(context).load(contactslist.get(position).getFileUrl()).into(imageView);
            //    context.startActivity(new Intent(context,lesson_material.class));

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
            sub_Name=(TextView)itemView.findViewById(R.id.txt_image_title);
            image=(ImageView)itemView.findViewById(R.id.imageView3);

        }
    }}