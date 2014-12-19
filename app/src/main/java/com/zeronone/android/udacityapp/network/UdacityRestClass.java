package com.zeronone.android.udacityapp.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


/**
 * Created by zeronone on 12/18/14.
 */
public class UdacityRestClass {

    private static final String BASE_URL = "http://www.udacity.com/public-api/v0/";
    private static final AsyncHttpClient client = new AsyncHttpClient();

    public static String getAbsoluteUrl(String url) {
        return BASE_URL + url;
    }

    public static void allCourses(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        client.get(getAbsoluteUrl(url), params, handler);
    }


}
