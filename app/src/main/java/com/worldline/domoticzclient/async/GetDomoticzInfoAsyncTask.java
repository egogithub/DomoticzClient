package com.worldline.domoticzclient.async;

import android.os.AsyncTask;

import com.worldline.domoticzclient.DomoticzAPI;
import com.worldline.domoticzclient.interfaces.DomoticzInfoListener;
import com.worldline.domoticzclient.pojo.DomoticzInstance;

public class GetDomoticzInfoAsyncTask extends AsyncTask <String, Void, DomoticzInstance> {
    private DomoticzInfoListener mListener;

    public GetDomoticzInfoAsyncTask (DomoticzInfoListener listener) {
        mListener=listener;
    }

    @Override
    protected DomoticzInstance doInBackground(String... params) {
        if ((null != params) && (params.length>0)) {
            return DomoticzAPI.getDomoticzInfo(params[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(DomoticzInstance domoticzInstance) {
        if (null != domoticzInstance) {
            mListener.onDomoticzInfo(domoticzInstance);
        }
    }
}
