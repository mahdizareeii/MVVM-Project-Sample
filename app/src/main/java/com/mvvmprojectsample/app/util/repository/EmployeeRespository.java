package com.mvvmprojectsample.app.util.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvmprojectsample.app.model.employee.Employee;
import com.mvvmprojectsample.app.model.employee.EmployeeData;
import com.mvvmprojectsample.app.util.retrofit.OnCallBack;
import com.mvvmprojectsample.app.util.retrofit.RetrofitClient;
import com.mvvmprojectsample.app.util.retrofit.RetrofitHelper;

import java.util.List;

public class EmployeeRespository {

    private MutableLiveData<List<Employee>> employeeLiveData = new MutableLiveData<>();

    public LiveData<List<Employee>> getEmployeeLiveData() {

        new RetrofitHelper<EmployeeData>(RetrofitClient.getRetroftApi().getEmployees(), new OnCallBack<EmployeeData>() {
            @Override
            public void onCallBack(EmployeeData employeeData) {
                employeeLiveData.setValue(employeeData.getEmployees());
            }
        });

        return employeeLiveData;
    }

}
