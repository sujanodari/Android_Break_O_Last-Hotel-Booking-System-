package com.sujan.break_o_last;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sujan.break_o_last.bll.LoginBll;
import com.sujan.break_o_last.strictMode.StrictModeClass;
import com.sujan.break_o_last.ui.registration.ForgetActivity;
import com.sujan.break_o_last.ui.registration.RegistrationActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login;
    TextView tvSignup, forget;
    String user = "", pass = "";
    LinearLayout myLayout;
    AnimationDrawable animationDrawable;
    CheckBox loginCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Gyro();
        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginCheck = findViewById(R.id.loginCheck);
        tvSignup = findViewById(R.id.tvSignup);
        forget = findViewById(R.id.forget);
        StrictModeClass.StrictMode();
        Proximity();
        chekckSharedPreferences();
        Login = findViewById(R.id.login);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);

                startActivity(intent);
            }
        });
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
                    login();

                } else {
                    if (TextUtils.isEmpty(user)) {
                        Username.setError("Enter Username");
                        vibrate();
                    }
                    if (TextUtils.isEmpty(pass)) {
                        Password.setError("Enter Password");
                        vibrate();
                    }
                    return;
                }
            }
        });


    }

    public void Gyro() {

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);


        SensorEventListener gyroEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[2] > 1.5f) {        // anticlockwise
                    Log.d("gyro", "tilted left");
                    Toast.makeText(LoginActivity.this, "tilted left", Toast.LENGTH_SHORT).show();
                } else if (event.values[2] < -1.5f) {     // clockwise
                    Toast.makeText(LoginActivity.this, "right tilted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
//    register listener
        sensorManager.registerListener(gyroEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void vibrate(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
        vibrator.vibrate(3000);
    }
    private void setPreferences() {



        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", Username.getText().toString().trim());
        editor.putString("password", Password.getText().toString().trim());
        editor.commit();

        Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
    }

    private void login() {

        LoginBll loginBll = new LoginBll();
        StrictModeClass.StrictMode();
        boolean res = loginBll.checkUser(user, pass);
        Toast.makeText(this, "" + res, Toast.LENGTH_SHORT).show();
        if (loginBll.checkUser(user, pass)) {
            setPreferences();
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra(EXTRA_MESSAGE, user);
            startActivity(intent);
            vibrate();
            finish();
        } else {
            Toast.makeText(this, "Either PhoneNumber or password is incorrect", Toast.LENGTH_SHORT).show();
            Username.requestFocus();
            vibrate();
        }

    }

    private void chekckSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        System.out.println("Username "+sharedPreferences.getString("username",""));

        if (sharedPreferences.contains("username")) {
            System.out.println(sharedPreferences.getString("username",""));
            Username.setText("" + sharedPreferences.getString("username",""));

        }
        if (sharedPreferences.contains("password")) {
            Password.setText("" + sharedPreferences.getString("password", ""));
        }


    }

    public void Proximity() {

        SensorManager proximitySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor proximoty = proximitySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        SensorEventListener proximityEventListener = new SensorEventListener() {



            @Override
            public void onSensorChanged(SensorEvent event) {
                float distance = event.values[0];
                if(distance<=2){
                   // Toast.makeText(LoginActivity.this, "Please Keep The Device Far From You", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
//    register listener
        proximitySensorManager.registerListener(proximityEventListener, proximoty, SensorManager.SENSOR_DELAY_NORMAL);

    }
}
