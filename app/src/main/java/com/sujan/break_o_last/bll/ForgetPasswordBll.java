package com.sujan.break_o_last.bll;

import com.sujan.break_o_last.api.HotelAPI;
import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.responses.LoginResponses;
import com.sujan.break_o_last.url.BaseUrl;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ForgetPasswordBll {

    boolean isSuccess = false;

    public boolean forgetPassword(String user, String pass) {
        String Name="",Address="",Email="",Cpass="",Gender="";
        CreateUser rg =new CreateUser(Name,user,Address,Email,pass,Cpass,Gender,"Profile");
        HotelAPI hotelAPI= BaseUrl.getInstance().create(HotelAPI.class);
        Call<LoginResponses> usersCall = hotelAPI.forgetPassword(rg);
        try {
            Response<LoginResponses> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("success")) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

