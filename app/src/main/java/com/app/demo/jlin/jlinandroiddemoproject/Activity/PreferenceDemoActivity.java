package com.app.demo.jlin.jlinandroiddemoproject.Activity;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.demo.jlin.jlinandroiddemoproject.Constants.Constants;
import com.app.demo.jlin.jlinandroiddemoproject.Preference.MyPreference;
import com.app.demo.jlin.jlinandroiddemoproject.R;
import com.app.demo.jlin.jlinandroiddemoproject.databinding.ActivityPreferenceDemoBinding;

public class PreferenceDemoActivity extends AppCompatActivity {
    private ActivityPreferenceDemoBinding binding;
    private MyPreference myPreference;
    private String[] stringArray = {"111","222","333","444"};
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_preference_demo);

        myPreference = new MyPreference(this);

        //加入監聽器
        myPreference.addChangeListener(onSharedPreferenceChangeListener);

        //註冊click event
        binding.btnPreferenceSetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index > stringArray.length - 1){
                    index = 0;
                }
                myPreference.setValue(stringArray[index]);
                index++;
            }
        });
    }

    /**
     * destroy 時移除監聽
     * */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myPreference.removeChangeListener(onSharedPreferenceChangeListener);
    }

    /**
     * 實作preference change listener
     * */
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            String result ;
            if(sharedPreferences instanceof MyPreference){
                result = ((MyPreference)sharedPreferences).getValue();
            }else{
                result = sharedPreferences.getString(Constants.KEY,"");
            }

            if(result.equals("")){
                binding.textPreference.setText("查無資料");
            }else {
                binding.textPreference.setText(result);
            }
        }
    };
}
