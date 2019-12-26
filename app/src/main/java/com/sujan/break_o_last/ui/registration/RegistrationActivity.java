package com.sujan.break_o_last.ui.registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sujan.break_o_last.LoginActivity;
import com.sujan.break_o_last.R;
import com.sujan.break_o_last.api.HotelAPI;
import com.sujan.break_o_last.models.CreateUser;
import com.sujan.break_o_last.url.BaseUrl;

import java.util.jar.Attributes;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    CircleImageView profileImage;
    EditText uName,uPhone,uAddress,uEmail,uPass,uCPass;
    RadioButton uMale,uFemale,uOthers;
    Button register;
    TextView login;
    String Name,Phone,Address,Email,Cpass,Pass,Gender;
    Bitmap Profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        uName=findViewById(R.id.uname);
        uPhone=findViewById(R.id.number);
        uAddress=findViewById(R.id.address);
        uEmail=findViewById(R.id.email);
        uPass=findViewById(R.id.upassword);
        uCPass=findViewById(R.id.cpassword);

        uMale=findViewById(R.id.male);
        uFemale=findViewById(R.id.female);
        uOthers=findViewById(R.id.others);

        login=findViewById(R.id.ulogin);
        register=findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(uMale.isChecked()){
                        Gender="Male";
                    }else if(uFemale.isChecked()){
                        Gender="Female";
                    }else if(uOthers.isChecked()){
                        Gender="Others";
                    }
                    Name=uName.getText().toString().trim();
                    Phone=uPhone.getText().toString().trim();
                    Address=uAddress.getText().toString().trim();
                    Email=uEmail.getText().toString().trim();
                    Cpass=uCPass.getText().toString().trim();
                    Pass=uPass.getText().toString().trim();
                         if (TextUtils.isEmpty(Name)) {
                        uName.setError("Enter Username");
                    }
                    if (TextUtils.isEmpty(Phone)) {
                        uPhone.setError("Enter Phone Number");
                    }
                    if (TextUtils.isEmpty(Address)) {
                        uAddress.setError("Enter Address");
                    }
                    if (TextUtils.isEmpty(Email)) {
                        uEmail.setError("Enter Email");
                    }
                    if (TextUtils.isEmpty(Cpass)) {
                        uCPass.setError("Confirm Password ");
                    }
                    if (TextUtils.isEmpty(Pass)) {
                        uPass.setError("Enter Password");
                    }
                    if(!Pass.equals(Cpass)){
                        uCPass.setError("Password Won't match");
                    }

                    CreateUser user =new CreateUser(Name,Phone,Address,Email,Pass,Cpass,Gender,"Profile");
                HotelAPI hotelAPI= BaseUrl.getInstance().create(HotelAPI.class);
                retrofit2.Call<Void> voidCall=hotelAPI.registerUser(user);
               // Toast.makeText(RegistrationActivity.this, ""+profileImage, Toast.LENGTH_LONG).show();
                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(RegistrationActivity.this, "You have sucessfully registered", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(RegistrationActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


        profileImage=findViewById(R.id.profileImage);


        //check for permission
        checkPermission();


        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(RegistrationActivity.this,profileImage);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                     if(item.getTitle().toString().equals("Open Camera")){
                         loadCamera();
                     }
                        if(item.getTitle().toString().equals("Open Gallary")){
                            loadGallary();
                        }


                        return true;
                    }
                });
                popupMenu.show();


            }
        });


    }

    private void loadGallary() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }



    private  void checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.CAMERA
                    },0);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    },0);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0 && resultCode==RESULT_OK){
            Bundle extras= data.getExtras();
            Bitmap imageBitmap=(Bitmap)extras.get("data");
            profileImage.setImageBitmap(imageBitmap);
            Profile = imageBitmap;
        }
        if(requestCode==1 && resultCode==RESULT_OK) {

            if (data == null) {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_LONG).show();
            }
            Uri uri = data.getData();
            profileImage.setImageURI(uri);
        }
    }

    private  void loadCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,0);
        }

    }


}

