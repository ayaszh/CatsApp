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

    public Button btn_get_text;
    public TextView textView_fact;

    public FactFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_get_text = view.findViewById(R.id.btn_get_text);
        textView_fact = view.findViewById(R.id.textView_fact_text);

        presenter = new FactPresenter(this);

        btn_get_text.setOnClickListener((v) -> {
            presenter.getFactText();
        });
    }

    @Override
    public void showFact(String text) {
        textView_fact.setText(text);
    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(requireActivity(), "Ошибка при получении данных", Toast.LENGTH_LONG).show();
    }
}