package com.example.wooppaytask1.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wooppaytask1.mvp.MvpContract;
import com.example.wooppaytask1.mvp.presenter.Presenter;

public class Fragment extends androidx.fragment.app.Fragment implements MvpContract.View {
    /**
     * Пример работы с паттерном МВП
     */

    private MvpContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        presenter = new Presenter(this);
        button.setOnClickListener((v) -> {
            presenter.getText();
        });
        return null;
    }

    @Override
    public void showText(String text) {
        //показывать текст пользователю
    }

    @Override
    public void showError() {

    }
}
