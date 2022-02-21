package com.example.wooppaytask1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondFragment extends Fragment {

    Button btn_get_text;
    Button btn_translate_text;
    TextView textView_original_text;

    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_get_text = view.findViewById(R.id.btn_get_text);
        btn_translate_text = view.findViewById(R.id.btn_translate_text);
        textView_original_text = view.findViewById(R.id.textView_fact_text);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        btn_get_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://catfact.ninja/facts";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String result = jsonObject.getString("fact");
                                textView_original_text.setText(result);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

        btn_translate_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                translate_api translate = new translate_api();
                translate.setOnTranslationCompleteListener(new translate_api.OnTranslationCompleteListener() {
                    @Override
                    public void onStartTranslation() {

                      }

                    @Override
                    public void onCompleted(String text) {
                        textView_original_text.setText(text);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                translate.execute(textView_original_text.getText().toString(), "en", "ru");
            }
        });
    }
}