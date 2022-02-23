package com.example.wooppaytask1.mvp;

public class Model {
    private final ModelListener listener;

    public Model(ModelListener listener) {
        this.listener = listener;
    }

    /**
     * метод вызывает retrofit и отправляет асинхронный запрос, в асинхронный запрос
     * в коллбэке использует ModelListener.onSuccess и ModelListener.onError
     */
    public void asyncGetTextRequest() {
        //вызывает retrofit
    }

    public interface ModelListener {
        void onSuccess(String text);
        void onError();
    }
}
