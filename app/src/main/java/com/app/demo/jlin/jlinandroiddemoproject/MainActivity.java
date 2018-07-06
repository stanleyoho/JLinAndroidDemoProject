package com.app.demo.jlin.jlinandroiddemoproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.demo.jlin.jlinandroiddemoproject.Activity.PreferenceDemoActivity;
import com.app.demo.jlin.jlinandroiddemoproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btnPreference.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            switch (viewId){
                case R.id.btnPreference:
                    startActivity(new Intent(MainActivity.this, PreferenceDemoActivity.class));
                    break;
            }
        }
    };
}
