package com.company.API;

import okhttp3.*;

import java.io.IOException;

public class ApiClient {
    private static ApiClient mInstance = new ApiClient();
    private static OkHttpClient mClient = new OkHttpClient();

    public static ApiClient getInstance() {
        return mInstance;
    }

    private ApiClient() {
    }

    private OkHttpClient getClient(){
        return mClient;
    }

    public static final MediaType XML
            = MediaType.parse("application/xml; charset=utf-8");


    private String post(String url, String xml) throws IOException {
        RequestBody body = RequestBody.create(XML, xml);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = mClient.newCall(request).execute();
        return response.body().string();
    }

}
