package com.example.wooppaytask1.mvp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wooppaytask1.R;

public class ImageFragment extends Fragment {

    private final String BASE_URL = "https://cataas.com//cat/says/";

    public ImageFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText user_field = view.findViewById(R.id.user_field);
        Button btn_get_image = view.findViewById(R.id.btn_get_image);
        ImageView imageView_get_image = view.findViewById(R.id.imageView_get_image);

        btn_get_image.setOnClickListener(view1 -> {
            if(user_field.getText().toString().trim().equals(""))
                user_field.setError("Недостаточно символов");
            else {
                String url = BASE_URL + user_field.getText();
                Glide.with(requireActivity())
                        .load(url)
                        .into(imageView_get_image);
            }
        });
    }
}
