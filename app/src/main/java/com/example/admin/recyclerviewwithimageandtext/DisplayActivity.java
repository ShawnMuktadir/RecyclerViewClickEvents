package com.example.admin.recyclerviewwithimageandtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = (ImageView)findViewById(R.id.album_display);

        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
    }
}
