package com.zing.ablue.testhttp.servicies;

import com.zing.ablue.testhttp.entities.HttpResultEntity;
import com.zing.ablue.testhttp.entities.LoginRequestEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zing on 2017/1/8.
 */

public interface DemoRequest {
    @POST("/api/user/login/")
    Observable<HttpResultEntity<String>> login(@Body LoginRequestEntity user);
//    Observable<HttpResultEntity<String>> login(LoginRequestEntity user);

}
