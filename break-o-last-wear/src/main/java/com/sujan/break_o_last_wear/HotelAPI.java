package com.sujan.break_o_last_wear;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HotelAPI {

    //login user
    @POST("users/signin")
    Call<LoginResponses>login(@Body CreateUser user);
    @GET("hotel/rooms")
    Call<JSONResponse> getHotelRooms();

}
