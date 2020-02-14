package com.mvvmprojectsample.app.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvmprojectsample.app.model.employee.Employee;
import com.mvvmprojectsample.app.repository.EmployeeRespository;

import java.util.List;

public class MainViewModel extends ViewModel {

    public LiveData<List<Employee>> getEmployees() {
        return new EmployeeRespository().getEmployeeLiveData();
    }

}
