package com.sujan.break_o_last.bll;

import com.sujan.break_o_last.api.HotelAPI;
import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.responses.SignUpResponse;
import com.sujan.break_o_last.ui.registration.RegistrationActivity;
import com.sujan.break_o_last.url.BaseUrl;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class RegistrationBll {
    boolean isSuccess = false;

    public boolean registerUser(String Name, String Phone, String Address, String Email, String Pass, String Cpass, String Gender, String Profile) {

        CreateUser rg = new CreateUser(Name, Phone, Address, Email, Pass, Cpass, Gender, Profile);
        HotelAPI hotelAPI = BaseUrl.getInstance().create(HotelAPI.class);
        Call<SignUpResponse> usersCall = hotelAPI.registerUser(rg);
        try {
            Response<SignUpResponse> signUpResponseResponse = usersCall.execute();
            if (signUpResponseResponse.isSuccessful() &&
                    signUpResponseResponse.body().getStatus().equals("success")) {
                isSuccess = true;
            }
            else if (signUpResponseResponse.isSuccessful() &&
                    signUpResponseResponse.body().getStatus().equals("error")) {
                RegistrationActivity.message = "Phone Number Already Exist, Please enter new one";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

