package com.sujan.break_o_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sujan.break_o_last.api.HotelAPI;
import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.ui.registration.RegistrationActivity;
import com.sujan.break_o_last.url.BaseUrl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login;
    TextView tvSignup;
    String user="", pass="";
    LinearLayout myLayout;
    AnimationDrawable animationDrawable;
    CheckBox loginCheck;
    String Name,Address,Email,Cpass,Gender;
    Bitmap Profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginCheck=findViewById(R.id.loginCheck);
        tvSignup=findViewById(R.id.tvSignup);

        Login = findViewById(R.id.login);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);

                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Username.getText().toString().trim();
                pass = Password.getText().toString().trim();


                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {

                    CreateUser rg =new CreateUser(Name,user,Address,Email,pass,Cpass,Gender,"Profile");
                    HotelAPI hotelAPI= BaseUrl.getInstance().create(HotelAPI.class);
                    retrofit2.Call<Void> voidCall=hotelAPI.login(rg);
                    voidCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "User not found" , Toast.LENGTH_SHORT).show();
                                Log.d("error", "error" + response.code());
                                return;
                            }
                            if(loginCheck.isChecked()){
                                setPreferences();}
                            Username.setText("");
                            Password.setText("");

                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                            intent.putExtra(EXTRA_MESSAGE, user);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {
                    if (TextUtils.isEmpty(user)) {
                        Username.setError("Enter Username");
                    }
                    if (TextUtils.isEmpty(pass)) {
                        Password.setError("Enter Password");
                    }
                    return;
                }
            }
        });



    }
        private void setPreferences(){

            SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();

            editor.putString("username",Username.getText().toString().trim());
            editor.putString("password",Password.getText().toString().trim());
            editor.commit();

            Toast.makeText(this, "Sucessfully Resistered", Toast.LENGTH_SHORT).show();



        }


}
