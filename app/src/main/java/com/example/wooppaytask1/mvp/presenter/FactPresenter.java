package com.example.wooppaytask1.mvp.presenter;

import com.example.wooppaytask1.mvp.contract.MvpContract;
import com.example.wooppaytask1.mvp.model.FactModel;

public class FactPresenter implements MvpContract.Presenter, MvpContract.Model.ModelListener {

    private MvpContract.View factView;
    private MvpContract.Model factModel;

    public FactPresenter(MvpContract.View factView){
        this.factView = factView;
        factModel = new FactModel();
    }

    @Override
    public void getFactText() {
        factModel.asyncGetFactRequest(this);
    }

    @Override
    public void onFinished(String text) {
        factView.showFact(text);
    }

    @Override
    public void onFailure(Throwable throwable) {
        factView.showError(throwable);
    }
}
