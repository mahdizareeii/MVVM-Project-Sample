package com.mvvmprojectsample.app.view.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mvvmprojectsample.app.R;
import com.mvvmprojectsample.app.databinding.SampleActivityBinding;
import com.mvvmprojectsample.app.viewModel.SampleViewModel;

public class SampleActivity extends AppCompatActivity {

    private SampleActivityBinding sampleActivityBinding;
    private SampleViewModel sampleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initAction();
    }

    private void initView() {
        sampleActivityBinding = DataBindingUtil.setContentView(SampleActivity.this, R.layout.sample_activity);
        sampleViewModel = new SampleViewModel();
        sampleActivityBinding.setMessage(sampleViewModel);
    }

    private void initAction() {

    }
}
