package com.example.ugcnetapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ugcnetapp.LoginActivity;
import com.example.ugcnetapp.MainActivity;
import com.example.ugcnetapp.ModalClass.ModalForUserDetails;
import com.example.ugcnetapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    TextView name,email;
    ImageView userImage;
    Button logout;
    FirebaseDatabase database;

    ModalForUserDetails modal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.user_name);
        email = findViewById(R.id.user_email);
        //userImage = findViewById(R.id.user_image);
        logout = findViewById(R.id.logout_btn);


       String user = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
       database = FirebaseDatabase.getInstance();

       database.getReference().child("user").child(user).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

               modal = new ModalForUserDetails();
               modal = snapshot.getValue(ModalForUserDetails.class);
               assert modal != null;
               name.setText(modal.getName());
               email.setText(modal.getEmail());

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

               Toast.makeText(ProfileActivity.this, "Not fetching data", Toast.LENGTH_SHORT).show();
           }
       });



        //name.setText(user.getDisplayName());
        //email.setText(user.getEmail());
        //Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(userImage);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
}