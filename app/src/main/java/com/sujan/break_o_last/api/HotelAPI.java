package com.sujan.break_o_last.api;

import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.responses.ImageResponse;
import com.sujan.break_o_last.responses.LoginResponses;
import com.sujan.break_o_last.responses.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HotelAPI {


    //Create user
    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body CreateUser usr);

    //login user
    @POST("users/signin")
    Call<LoginResponses>login(@Body CreateUser user);

    @Multipart
    @POST("users/profile")
    Call<ImageResponse>uploadImage(@Part MultipartBody.Part image);

    @GET("users/detail")
    Call<CreateUser> getUserDetails(@Header("Authorization")String token);

}
