package com.worldline.domoticzclient.interfaces;

import com.worldline.domoticzclient.pojo.TempHumidityDevice;

public interface TempHumInfoListener {
    public void onTempHumUpdate (TempHumidityDevice answer);
}
