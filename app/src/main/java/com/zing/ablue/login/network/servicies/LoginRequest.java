package com.zing.ablue.login.network.servicies;


import com.zing.ablue.login.network.entities.HttpResultEntity;
import com.zing.ablue.login.network.entities.LoginRequestEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zing on 2017/1/8.
 */

public interface LoginRequest {

    @POST("/api/user/login/")
    Observable<HttpResultEntity<String>> login(@Body LoginRequestEntity user);

}
