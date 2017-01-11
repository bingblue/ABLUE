package com.zing.ablue.login.network.servicies;


import com.zing.ablue.login.network.entities.HttpResultEntity;
import com.zing.ablue.login.network.entities.RegisterRequestEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zing on 2017/1/8.
 */

public interface RegisterRequest {

    @POST("/api/user/isRepeatByName/")
    Observable<HttpResultEntity<String>> invite(@Body RegisterRequestEntity user);

}
