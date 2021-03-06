package com.mvvmprojectsample.app.model.webService.employee;

import com.google.gson.annotations.SerializedName;
import com.mvvmprojectsample.app.model.webService.Response;

import java.util.List;

public class EmployeeData extends Response {

    @SerializedName("data")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
