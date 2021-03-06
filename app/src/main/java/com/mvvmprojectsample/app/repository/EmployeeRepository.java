package com.mvvmprojectsample.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvmprojectsample.app.model.webService.employee.Employee;
import com.mvvmprojectsample.app.model.webService.employee.EmployeeData;
import com.mvvmprojectsample.app.util.retrofit.OnCallBack;
import com.mvvmprojectsample.app.util.retrofit.RetrofitClient;
import com.mvvmprojectsample.app.util.retrofit.RetrofitHelper;

import java.util.List;

public class EmployeeRepository {

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
