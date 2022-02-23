package com.example.wooppaytask1.mvp;

public interface MvpContract {
    interface Presenter {
        void getText();
    }

    interface View {
        void showText(String text);
        void showError();
    }

    interface Model {
        void asyncGetTextRequest();
    }
}
