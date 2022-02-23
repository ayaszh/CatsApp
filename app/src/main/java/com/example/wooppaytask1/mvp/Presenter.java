package com.example.wooppaytask1.mvp;

public class Presenter implements Model.ModelListener {
    private final Model model;
    private final PresenterListener listener;

    public Presenter(PresenterListener listener) {
        this.listener = listener;
        this.model = new Model(this);
    }

    public void getText() {
        model.asyncGetTextRequest();
    }

    @Override
    public void onSuccess(String text) {
        listener.showText(text);
    }

    @Override
    public void onError() {
        listener.showError();
    }

    public interface PresenterListener {
        void showText(String text);
        void showError();
    }
}
