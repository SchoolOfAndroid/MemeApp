package com.workshop.vjti.introtoandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int SELECT_PICTURE = 0;

    Button button_select_image;
    Button buttom_make_meme;
    EditText edit_text_top;
    EditText edit_text_bottom;
    ImageView image_view_preview;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_select_image = (Button) findViewById(R.id.button_select_image);
        buttom_make_meme = (Button) findViewById(R.id.button_make_meme);
        edit_text_top = (EditText) findViewById(R.id.edit_text_top);
        edit_text_bottom = (EditText) findViewById(R.id.edit_text_bottom);
        image_view_preview = (ImageView) findViewById(R.id.image_view_preview);


    }

    public void select_image(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                SELECT_PICTURE);
    }

    public void make_meme(View view){
        if (uri == null){
            Toast.makeText(this, "Select an Image", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.setData(uri);

        intent.putExtra("top_text", edit_text_top.getText().toString());
        intent.putExtra("bottom_text", edit_text_bottom.getText().toString());
        startActivity(intent);
        finish();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            if (requestCode == SELECT_PICTURE) {
                uri = data.getData();
                image_view_preview.setImageURI(uri);
            }
        }
    }



}
