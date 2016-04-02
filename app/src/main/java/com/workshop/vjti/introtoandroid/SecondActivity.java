package com.workshop.vjti.introtoandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView image_view_meme;
    TextView text_view_top;
    TextView text_view_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // To hide status and navigation bars
        /*getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);*/

        image_view_meme = (ImageView) findViewById(R.id.image_view_meme);
        text_view_top = (TextView) findViewById(R.id.text_view_top);
        text_view_bottom = (TextView) findViewById(R.id.text_view_bottom);

        Intent intent = getIntent();

        String topText = intent.getStringExtra("top_text");
        String bottomText = intent.getStringExtra("bottom_text");

        text_view_top.setText(topText);
        text_view_bottom.setText(bottomText);

        Uri uri = intent.getData();
        image_view_meme.setImageURI(uri);

    }
}
