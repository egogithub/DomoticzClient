package com.worldline.domoticzclient.async;

import android.os.AsyncTask;

import com.worldline.domoticzclient.DomoticzAPI;
import com.worldline.domoticzclient.interfaces.TempHumInfoListener;
import com.worldline.domoticzclient.pojo.TempHumidityDevice;

public class GetTempAsyncTask extends AsyncTask <Integer, Void, TempHumidityDevice> {
    private TempHumInfoListener mListener;

    public GetTempAsyncTask(TempHumInfoListener listener) {
        mListener=listener;
    }

    @Override
    protected TempHumidityDevice doInBackground(Integer... params) {
        if ((null != params) && (params.length > 0)) {
            return DomoticzAPI.getTempHumidity(params[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(TempHumidityDevice tempHumDevice) {
        if (null != tempHumDevice) {
            mListener.onTempHumUpdate(tempHumDevice);
        }

    }
}
