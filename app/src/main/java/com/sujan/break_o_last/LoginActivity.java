package com.sujan.break_o_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);

        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Username.getText().toString().trim();
                pass = Password.getText().toString().trim();

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {

                    if (user.equals("admin") && pass.equals("admin")) {
                        Toast.makeText(LoginActivity.this, "Login Successful, Welcome: " + user, Toast.LENGTH_SHORT).show();
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
}
