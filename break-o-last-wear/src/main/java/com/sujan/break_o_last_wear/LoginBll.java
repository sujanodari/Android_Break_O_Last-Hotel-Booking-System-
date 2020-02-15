package com.sujan.break_o_last_wear;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {

        boolean isSuccess = false;

    public boolean checkUser(String user, String pass) {
           String Name="",Address="",Email="",Cpass="",Gender="";
           CreateUser rg =new CreateUser(Name,user,Address,Email,pass,Cpass,Gender,"Profile");
           HotelAPI hotelAPI= BaseUrl.getInstance().create(HotelAPI.class);
            Call<LoginResponses> usersCall = hotelAPI.login(rg);
            try {
                Response<LoginResponses> loginResponse = usersCall.execute();
                if (loginResponse.isSuccessful() &&
                         loginResponse.body().getStatus().equals("Success")) {
                         isSuccess = true;
                         BaseUrl.Token="Bearer "+loginResponse.body().usertoken;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return isSuccess;
        }
    }

