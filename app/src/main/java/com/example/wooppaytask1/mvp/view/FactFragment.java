package com.example.wooppaytask1.mvp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wooppaytask1.R;
import com.example.wooppaytask1.mvp.contract.MvpContract;
import com.example.wooppaytask1.mvp.presenter.FactPresenter;

public class FactFragment extends Fragment implements MvpContract.View {

    private MvpContract.Presenter presenter;

    public Button buttonGetText;
    public TextView textViewFact;

    public FactFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonGetText = view.findViewById(R.id.buttonGetText);
        textViewFact = view.findViewById(R.id.textViewFact);

        presenter = new FactPresenter(this);

        buttonGetText.setOnClickListener((v) -> {
            presenter.getFactText();
        });
    }

    @Override
    public void showFact(String text) {
        textViewFact.setText(text);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(requireActivity(), "Ошибка при получении данных", Toast.LENGTH_LONG).show();
    }
}