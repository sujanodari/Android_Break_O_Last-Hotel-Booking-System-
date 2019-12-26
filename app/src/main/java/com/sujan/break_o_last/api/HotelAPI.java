package com.sujan.break_o_last.api;

import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.responses.ImageResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HotelAPI {


    //Create user
    @POST("users/signup")
    Call<Void> registerUser(@Body CreateUser usr);

    //login user
    @POST("users/signin")
    Call<Void>login(@Body CreateUser user);

    @Multipart
    @POST("users/profile")
    Call<ImageResponse>uploadImage(@Part MultipartBody.Part image);
}
