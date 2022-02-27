package com.example.wooppaytask1.mvp.contract;

public interface MvpContract {

    interface Model {
        interface ModelListener {
            void onFinished(String text);
            void onFailure(Throwable t);
        }
        void asyncGetFactRequest(ModelListener modelListener);
    }

    interface Presenter {
        void getFactText();
    }

    interface View {
        void showFact(String text);
        void showError(Throwable t);
    }
}
