package com.example.ugcnetapp.authentication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ugcnetapp.LoginActivity;
import com.example.ugcnetapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {

    EditText regName,regEmail,regPassword;
    Button regButton,loginBtn;
    private FirebaseAuth auth;
    FirebaseDatabase database;

    ImageView userImage;
    static int REQUEST_CODE = 1;
    Uri pickedImgUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regButton = findViewById(R.id.reg_button);
        loginBtn = findViewById(R.id.reg_login_btn);
        userImage = findViewById(R.id.regImage);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

//        userImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openGallery();
//            }
//        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }

            private void registerUser() {
                String name,email,password;
                name = regName.getText().toString().trim();
                email = regEmail.getText().toString().trim();
                password = regPassword.getText().toString().trim();
                if (name.isEmpty() || TextUtils.isEmpty(email) || password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please Fill all Details", Toast.LENGTH_SHORT).show();
                }else {
                    auth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
//                                        Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                       // updateUI(name,pickedImgUri,auth.getCurrentUser());
                                        //openProfile();
                                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                                        String currentUser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
                                        assert firebaseUser != null;
                                        firebaseUser.sendEmailVerification();
                                        HashMap<String, Object> userDetails = new HashMap<>();
                                        userDetails.put("name", name);
                                        userDetails.put("email", email );
                                        userDetails.put("password", password );

                                        database.getReference().child("user").child(currentUser).setValue(userDetails)
                                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void unused) {
                                                                Toast.makeText(RegisterActivity.this, "Register Successfully! Check email for verification", Toast.LENGTH_SHORT).show();
                                                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                                            }
                                                        });

                                    }else {
                                        Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    private void openProfile() {
        startActivity(new Intent(RegisterActivity.this,ProfileActivity.class));
        finish();
    }

    private void updateUI(String name, Uri pickedImgUri, FirebaseUser currentUser) {;
//        StorageRefence mStorage = FirebaseStorage.getInstance().getReference().child("user_image");
//        final StotageReference imageFilepath = mStorage.child(pickedImgUri.getLastPathSegment());
//        imageFilepath.putFile(pickedImgUri)
    }

//    private void openGallery() {
//        startActivityForResult(new Intent()
//                .setAction(Intent.ACTION_GET_CONTENT)
//                .setType("image/*"),REQUEST_CODE);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if (data != null){
                pickedImgUri = data.getData();
                userImage.setImageURI(pickedImgUri);
            }
        }
    }

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }
}