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
import com.atschoolPioneerSchool.activity_semester;
import com.atschoolPioneerSchool.new_model.subject_content;
import com.bumptech.glide.Glide;

import java.util.List;

public class subject_RecyclerAdapter extends RecyclerView.Adapter<subject_RecyclerAdapter.MyViewHolder> {

    private Context context;
    List<subject_content> contactslist;
    private int i = 0;
    String _switchLang;
    public subject_RecyclerAdapter(Context context, List<subject_content> contactslist) {
        this.contactslist = contactslist;
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_subjects_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        _switchLang= context.getResources().getConfiguration().locale.getLanguage();

       if(_switchLang.equals("ar")||contactslist.get(position).equals("")) {
            holder.sub_Name.setText(contactslist.get(position).getNameA());
        }
        else{
            holder.sub_Name.setText(contactslist.get(position).getName());
        }
    //    holder.num_chapter.setText(contactslist.get(position).);
        if(contactslist.get(position).getImgaeOfSubject()== null){
            Glide.with(context).load(R.drawable.test_your_self_icon).into(holder.image);
        }
        else {
            Glide.with(context).load(contactslist.get(position).getImgaeOfSubject()).into(holder.image);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int id =contactslist.get(position).getId();
              Intent intent=new Intent(context,activity_semester.class);
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
        TextView sub_Name,num_chapter;
        ImageView image;
    public MyViewHolder(View itemView) {
        super(itemView);
        sub_Name=(TextView)itemView.findViewById(R.id.txt_subject_title);
        num_chapter=(TextView)itemView.findViewById(R.id.txt_units_num);
        image=(ImageView)itemView.findViewById(R.id.imageView3);

    }
}}