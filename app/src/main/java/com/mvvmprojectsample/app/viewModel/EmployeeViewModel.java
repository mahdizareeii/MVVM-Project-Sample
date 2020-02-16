package com.mvvmprojectsample.app.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvmprojectsample.app.model.webService.employee.Employee;
import com.mvvmprojectsample.app.repository.EmployeeRepository;

import java.util.List;

public class EmployeeViewModel extends ViewModel {

    public LiveData<List<Employee>> getEmployees() {
        return new EmployeeRepository().getEmployeeLiveData();
    }

}
