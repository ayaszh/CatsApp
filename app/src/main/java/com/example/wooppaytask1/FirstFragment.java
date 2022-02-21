package com.example.wooppaytask1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class FirstFragment extends Fragment {

    EditText user_field;
    Button btn_get_image;
    ImageView imageView_get_image;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user_field = view.findViewById(R.id.user_field);
        btn_get_image = view.findViewById(R.id.btn_get_image);
        imageView_get_image = view.findViewById(R.id.imageView_get_image);

        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_field.getText().toString().trim().equals(""))
                    user_field.setError("Недостаточно символов");
                else {
                    String url = "https://cataas.com/cat";
                    LoadImage loadImage = new LoadImage(imageView_get_image);
                    loadImage.execute(url);
                }
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private class LoadImage extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public LoadImage(ImageView imageView_get_image){
            this.imageView = imageView_get_image;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings [0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView_get_image.setImageBitmap(bitmap);
        }
    }
}

