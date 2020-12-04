package com.sujan.break_o_last_wear;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends WearableActivity {

EditText username,password;
Button login;
String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString().trim();
                pass = password.getText().toString().trim();


                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    login();

                } else {
                    if (TextUtils.isEmpty(user)) {
                        username.setError("Enter Username");
                    }
                    if (TextUtils.isEmpty(pass)) {
                        password.setError("Enter Password");
                    }
                    return;
                }
            }
        });

        setAmbientEnabled();
    }

    private void login() {


        LoginBll loginBll = new LoginBll();
        StrictModeClass.StrictMode();
        boolean res = loginBll.checkUser(user, pass);
        Toast.makeText(this, "" + res, Toast.LENGTH_SHORT).show();
        if (loginBll.checkUser(user, pass)) {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            intent.putExtra(EXTRA_MESSAGE, user);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either PhoneNumber or password is incorrect", Toast.LENGTH_SHORT).show();
            username.requestFocus();
        }
    }
}
