package com.worldline.domoticzclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.worldline.domoticzclient.async.GetDomoticzInfoAsyncTask;
import com.worldline.domoticzclient.async.GetTempAsyncTask;
import com.worldline.domoticzclient.interfaces.DomoticzInfoListener;
import com.worldline.domoticzclient.interfaces.TempHumInfoListener;
import com.worldline.domoticzclient.pojo.DomoticzInstance;
import com.worldline.domoticzclient.pojo.TempHumidityDevice;

public class MainActivity extends AppCompatActivity implements DomoticzInfoListener, TempHumInfoListener {

    GetDomoticzInfoAsyncTask mGetInfoTask;
    GetTempAsyncTask mGetTempInfoTask;
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = findViewById(R.id.btnGetInfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDmInfo();
            }
        });
        final Button buttonDevInfo = findViewById(R.id.btnGetDeviceInfo);
        buttonDevInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDeviceInfo();
            }
        });

    }

    private void getDeviceInfo() {
        Log.d(TAG, "Getting Temperature info");
        Integer idx = new Integer(1);
        mGetTempInfoTask = new GetTempAsyncTask(this);
        mGetTempInfoTask.execute(idx);
    }

    private void getDmInfo() {
        Log.d(TAG, "Getting Domoticz info");
        mGetInfoTask = new GetDomoticzInfoAsyncTask(this);
        mGetInfoTask.execute("info");
    }

    @Override
    public void onDomoticzInfo(DomoticzInstance dmInfo) {
        Log.d(TAG, "Revision: "+dmInfo.rev);
        Log.d(TAG, "SystemName: "+dmInfo.systemName);
        Log.d(TAG, "build_time: "+dmInfo.build_time);
        Log.d(TAG, "status: "+dmInfo.status);
        Log.d(TAG, "version: "+dmInfo.version);
    }

    @Override
    public void onTempHumUpdate(TempHumidityDevice answer) {
        Log.d(TAG, "Battery Level = "+answer.getBatteryLevel());
        Log.d(TAG, "Temperature = "+answer.getTemp());
        Log.d(TAG, "Humidity = "+answer.getHumidity());

    }
}