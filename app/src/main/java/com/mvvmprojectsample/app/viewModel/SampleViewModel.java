package com.mvvmprojectsample.app.viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.mvvmprojectsample.app.model.Sample;

public class SampleViewModel extends BaseObservable {

    private String title;
    private String description;

    public void setSample(Sample sample) {
        this.title = sample.getTitle();
        this.description = sample.getDescription();
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
}
