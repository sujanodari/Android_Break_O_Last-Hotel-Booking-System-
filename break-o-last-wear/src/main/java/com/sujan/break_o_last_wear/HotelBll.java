package com.sujan.break_o_last_wear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Response;

public class HotelBll {
    public void getHotel() {

        HotelAPI hotelAPI = BaseUrl.getInstance().create(HotelAPI.class);
        Call<JSONResponse> hotelCall = hotelAPI.getHotelRooms(BaseUrl.Token);
        try {
            Response<JSONResponse> hotelCallResponse = hotelCall.execute();
            if (hotelCallResponse.isSuccessful()) {
                HotelActivity.hotelList= new ArrayList<>(Arrays.asList(hotelCallResponse.body().getData()));
               }
    } catch (IOException e) {
        e.printStackTrace();
    }

        }
    }

