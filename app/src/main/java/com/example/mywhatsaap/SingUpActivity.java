package com.example.mywhatsaap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mywhatsaap.Modale.User;
import com.example.mywhatsaap.databinding.ActivityMainBinding;
import com.example.mywhatsaap.databinding.ActivitySingUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SingUpActivity extends AppCompatActivity {
    ActivitySingUpBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase Database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        mAuth=FirebaseAuth.getInstance();
        Database=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(SingUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are Creating Your Account");

        binding.btSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                mAuth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            User user =new User(binding.etUserName.getText().toString(), binding.etEmail.getText().toString() ,
                                    binding.etPassword.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            Database.getReference().child("user").child(id).setValue(user);

                            {

                            }
                            Toast.makeText(SingUpActivity.this,"user Created Successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SingUpActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        binding.Alaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingUpActivity.this, SingInActivity.class);
                startActivity(intent);
            }
        });




    }
}