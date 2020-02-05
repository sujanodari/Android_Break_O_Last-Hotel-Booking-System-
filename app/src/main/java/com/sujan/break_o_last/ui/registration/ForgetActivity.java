package com.sujan.break_o_last.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sujan.break_o_last.LoginActivity;
import com.sujan.break_o_last.R;
import com.sujan.break_o_last.bll.ForgetPasswordBll;
import com.sujan.break_o_last.strictMode.StrictModeClass;

public class ForgetActivity extends AppCompatActivity {
Button update;
TextView tvBack;
EditText upassword,uusername;
String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        update=findViewById(R.id.update);
        tvBack=findViewById(R.id.tvBack);
        upassword=findViewById(R.id.upassword);
        uusername=findViewById(R.id.uusername);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ForgetActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = uusername.getText().toString().trim();
                pass = upassword.getText().toString().trim();


                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    forget();

                } else {
                    if (TextUtils.isEmpty(user)) {
                        uusername.setError("Enter phone number");
                    }
                    if (TextUtils.isEmpty(pass)) {
                        upassword.setError("Enter Password");
                    }
                    return;
                }
            }
        });

    }

    private void forget() {
        ForgetPasswordBll forgetPasswordBll = new ForgetPasswordBll();
        StrictModeClass.StrictMode();
        boolean res=forgetPasswordBll.forgetPassword(user, pass);
        if (res) {
            Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Password updated Sucessfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "PhoneNumber is incorrect", Toast.LENGTH_SHORT).show();
            uusername.requestFocus();
        }

    }
}
