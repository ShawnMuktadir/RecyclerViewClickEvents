package com.example.admin.recyclerviewwithimageandtext;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyImageViewHolder> {

    private int[] images;
    private Context context;

    public RecyclerAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
        MyImageViewHolder imageViewHolder = new MyImageViewHolder(view,context,images);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyImageViewHolder viewHolder, int i) {

        int image_id = images[i];

        viewHolder.album.setImageResource(image_id);
        viewHolder.album_title.setText("Image : "+ i++);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView album;
        TextView album_title;
        Context context;
        int[] images;

        public MyImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);
            album = itemView.findViewById(R.id.album);
            album_title = itemView.findViewById(R.id.album_title);
            this.context = context;
            this.images = images;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,DisplayActivity.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);

            context.startActivity(intent);

        }
    }
}
