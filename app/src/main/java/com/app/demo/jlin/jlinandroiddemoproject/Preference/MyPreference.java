package com.app.demo.jlin.jlinandroiddemoproject.Preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.demo.jlin.jlinandroiddemoproject.Constants.Constants;

/**
 * Created by stanley.lin on 2018/7/6.
 */

public class MyPreference {
    private SharedPreferences userInfo;

    /**
     *  建構子 取得preference
     * */
    public MyPreference(Context context){
        //Context.MODE_PRIVATE
        //Context.MODE_WORLD_READABLE   This constant was deprecated in API level 17.   因為安全考量棄用
        //Context.MODE_WORLD_WRITEABLE  This constant was deprecated in API level 17.   因為安全考量棄用
        //Context.MODE_MULTI_PROCESS    This constant was deprecated in API level 23.   因為某些版本無法穩定運行所以棄用
        userInfo = context.getSharedPreferences(Constants.MY_PREFERENCE,Context.MODE_PRIVATE);
    }

    /**
     *  set value
     * */
    public void setValue(String string){
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString(Constants.KEY,string);
        editor.apply();
    }

    /**
     *  get value , 取不到值回傳“”
     * */
    public  String getValue(){
        return userInfo.getString(Constants.KEY,"");
    }

    /**
     * 開出接口 add listener
     * */
    public  void addChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener){
        if(onSharedPreferenceChangeListener != null){
            userInfo.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    /**
     * 開出接口 remove listener
     * */
    public  void removeChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener){
        if(onSharedPreferenceChangeListener != null){
            userInfo.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
