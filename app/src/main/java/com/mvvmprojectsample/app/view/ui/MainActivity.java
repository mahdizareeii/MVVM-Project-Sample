package com.mvvmprojectsample.app.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mvvmprojectsample.app.R;
import com.mvvmprojectsample.app.view.adapter.RVEmployeeAdapter;
import com.mvvmprojectsample.app.databinding.ActivityMainBinding;
import com.mvvmprojectsample.app.model.webService.employee.Employee;
import com.mvvmprojectsample.app.viewModel.EmployeeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initAction();
    }

    private void initView() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        employeeViewModel = ViewModelProviders.of(MainActivity.this).get(EmployeeViewModel.class);
    }

    private void initAction() {
        getEmployeeList();
    }

    private void getEmployeeList() {
        employeeViewModel.getEmployees().observe(MainActivity.this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> list) {
                initRecyclerView(list);
            }
        });
    }

    private void initRecyclerView(List<Employee> list) {
        RVEmployeeAdapter adapter = new RVEmployeeAdapter();
        RecyclerView recyclerView = activityMainBinding.employeeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.updateList(list);
    }
}
