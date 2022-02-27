package com.example.wooppaytask1.mvp.presenter;

import com.example.wooppaytask1.mvp.contract.MvpContract;
import com.example.wooppaytask1.mvp.model.FactListModel;

public class FactPresenter implements MvpContract.Presenter, MvpContract.Model.ModelListener {

    private MvpContract.View factView;
    private MvpContract.Model factModel;

    public FactPresenter(MvpContract.View factView){
        this.factView = factView;
        factModel = new FactListModel();
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
    public void onFailure(Throwable t) {
        factView.showError(t);
    }
}
