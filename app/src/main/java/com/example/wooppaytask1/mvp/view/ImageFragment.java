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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wooppaytask1.R;

public class ImageFragment extends Fragment {

    private final String BASE_URL = "https://cataas.com//cat/says/";

    public ImageFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText userField = view.findViewById(R.id.userField);
        Button buttonGetImage = view.findViewById(R.id.buttonGetImage);
        ImageView imageViewGetImage = view.findViewById(R.id.imageViewGetImage);

        buttonGetImage.setOnClickListener(view1 -> {
            if(userField.getText().toString().trim().equals(""))
                userField.setError("Недостаточно символов");
            else {
                String url = BASE_URL + userField.getText();
                Glide.with(requireActivity())
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(imageViewGetImage);
            }
        });
    }
}
