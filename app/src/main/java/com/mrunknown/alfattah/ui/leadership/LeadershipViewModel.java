package com.mrunknown.alfattah.ui.leadership;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LeadershipViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LeadershipViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Leadership fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}