package com.example.lyy.quartertheeightgroup.model.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;



public class CommonHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request =  chain.request();

        Request.Builder builder =  request.newBuilder() ;


        return chain.proceed(builder.build());
    }
}
