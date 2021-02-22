package com.worldline.domoticzclient;

import android.app.Activity;
import android.os.Bundle;

import com.worldline.domoticzclient.fragments.SensorsFragment;

import androidx.annotation.Nullable;

public class DomoticzActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domoticz);

        if (savedInstanceState == null) {
            //getFragmentManager().beginTransaction().add(R.id.fragment_container, new SensorsFragment()).commit();
        }
    }
}
