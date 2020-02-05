package com.sujan.break_o_last.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sujan.break_o_last.DashboardActivity;
import com.sujan.break_o_last.LoginActivity;
import com.sujan.break_o_last.R;
import com.sujan.break_o_last.bll.UserDeleteBll;
import com.sujan.break_o_last.strictMode.StrictModeClass;

public class DeleteActivity extends AppCompatActivity {
Button delete;
TextView tvCancel;
public static Boolean res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete=findViewById(R.id.delete);
        tvCancel=findViewById(R.id.tvCancel);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictModeClass.StrictMode();
                UserDeleteBll userDeleteBll = new UserDeleteBll();
                res=userDeleteBll.delete();
                if(res){
                    Toast.makeText(DeleteActivity.this, "User Delete Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeleteActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
