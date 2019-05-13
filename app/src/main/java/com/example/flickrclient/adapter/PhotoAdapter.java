package com.example.flickrclient.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.flickrclient.R;
import com.example.flickrclient.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.CustomViewHolder> {

    List<Photo> photos;
    Activity activity;

    public PhotoAdapter(List<Photo> photos, Activity activity) {
        this.photos = photos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new PhotoAdapter.CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int position) {
        Picasso.with(activity).load(photos.get(position).createURL()).into(customViewHolder.imageResource);

        customViewHolder.imageResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageResource;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageResource = (ImageView) itemView.findViewById(R.id.image_resource);
        }
    }


}
