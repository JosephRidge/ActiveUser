package com.jayr.activeusers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jayr.activeusers.Models.UploadedPhoto;
import com.jayr.activeusers.Models.Users;
import com.jayr.activeusers.R;

import java.util.ArrayList;
import java.util.List;

public class UserPhotoAdapter extends RecyclerView.Adapter<UserPhotoAdapter.ViewHolder> {
    Context context;
    List<UploadedPhoto> photoList;
    List<UploadedPhoto>photoListAll;
    public UserPhotoAdapter(List<UploadedPhoto> photoList, List<UploadedPhoto> photoListAll) {
        this.photoList = photoList;
        this.photoListAll = photoListAll;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.uploaded_image);
        }
    }

    @NonNull
    @Override
    public UserPhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_gallery_row, parent, false);
        return new UserPhotoAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserPhotoAdapter.ViewHolder holder, int position) {
//    Users users = usersList.get(position);
       holder.imageView.setImageURI(this.photoList.get(position).getUri());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
