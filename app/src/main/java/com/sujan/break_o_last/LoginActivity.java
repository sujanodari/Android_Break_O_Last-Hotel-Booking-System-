package com.sujan.break_o_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login;
    String user, pass;
    LinearLayout myLayout;
    AnimationDrawable animationDrawable;
    CheckBox loginCheck;

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

        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Username.getText().toString().trim();
                pass = Password.getText().toString().trim();


                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {

                    if (user.equals("admin") && pass.equals("admin")) {
                        if(loginCheck.isChecked()){
                        setPreferences();}
                        Username.setText("");
                        Password.setText("");

                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, user);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                        Username.setText("");
                        Password.setText("");
                    }


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
