package com.example.mywhatsaap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.mywhatsaap.databinding.ActivityChatDetailBinding;

public class ChatDetailActivity extends AppCompatActivity {
    ActivityChatDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}