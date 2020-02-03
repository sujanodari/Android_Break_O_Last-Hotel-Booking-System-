package com.sujan.break_o_last.bll;

import com.sujan.break_o_last.api.HotelAPI;
import com.sujan.break_o_last.responses.JSONResponse;
import com.sujan.break_o_last.ui.home.HomeFragment;
import com.sujan.break_o_last.url.BaseUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Response;

public class HotelBll {
    public void getHotel() {

        HotelAPI hotelAPI = BaseUrl.getInstance().create(HotelAPI.class);
        Call<JSONResponse> hotelCall = hotelAPI.getHotelRooms();
        try {
            Response<JSONResponse> hotelCallResponse = hotelCall.execute();
            if (hotelCallResponse.isSuccessful()) {
                HomeFragment.hotelList= new ArrayList<>(Arrays.asList(hotelCallResponse.body().getData()));
               }
    } catch (IOException e) {
        e.printStackTrace();
    }

        }
    }

