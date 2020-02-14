package com.mvvmprojectsample.app.util.retrofit;

import com.mvvmprojectsample.app.model.employee.EmployeeData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("users/?per_page=12&page=1")
    Observable<EmployeeData> getEmployees();

}
