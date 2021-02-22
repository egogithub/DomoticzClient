package com.worldline.domoticzclient;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.worldline.domoticzclient.pojo.DomoticzInstance;
import com.worldline.domoticzclient.pojo.TempHumidityDevice;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class DomoticzAPI {

    private static final String TAG = "MainActivity";
    public static final String BASE_URL = "http://192.168.0.135:8080/json.htm";

    //public static DomoticzAPI getInstance() {

    //}

    public static void getDeviceInfo (Integer idx) {
       try {
           Log.d(TAG, "Getting information from device "+idx);
           final HttpURLConnection connection = getHttpUrlConnection(BASE_URL + "?type=devices&rid="+idx);
           connection.setRequestMethod("GET");
           connection.setRequestProperty("User-Agent", "Mozilla/5.0");
           connection.setRequestProperty("Content-Type", "application/json");
           final int responseCode = connection.getResponseCode();
           Log.d(TAG,"Response code "+responseCode);
           if (responseCode == 200) {
               Gson gson = new Gson();
               Map<?, ?> map = gson.fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")), Map.class);

           }
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
    public static TempHumidityDevice getTempHumidity(Integer idx) {
        try {
            Log.d(TAG, "getting Temperature Device Info");
            final HttpURLConnection connection = getHttpUrlConnection(BASE_URL + "?type=devices&rid="+idx);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/json");
            final int responseCode = connection.getResponseCode();
            Log.d(TAG,"Response code "+responseCode);
            // If success
            if (responseCode == 200) {
                Gson gson = new Gson();

                JsonObject domAnswerJsonObject = gson.fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")),JsonObject.class);
                String status = domAnswerJsonObject.get("status").getAsString();
                Log.d(TAG, "Status = "+status);
                String title = domAnswerJsonObject.get("title").getAsString();
                Log.d(TAG,"Title = "+title);

                JsonArray resultArray = domAnswerJsonObject.get("result").getAsJsonArray();
                Log.d(TAG,"Result array = "+resultArray.toString()+"\n");

                if (resultArray.size()>0) {
                    Log.d(TAG, "At least one result found");

                    JsonObject deviceJson = resultArray.get(0).getAsJsonObject();

                    String deviceType = deviceJson.get("Type").getAsString();
                    Log.d(TAG, "Device of type "+deviceType);

                    if (deviceType.equals("Temp + Humidity")) {
                        TempHumidityDevice thDevice = gson.fromJson(deviceJson, TempHumidityDevice.class);
                        return thDevice;
                    }

                }


/*
                Map<?, ?> map = gson.fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")), Map.class);
                //System.out.println(map);
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }

                String status = (String)map.get("status");
                System.out.println("Status = "+status);
                if (status.equals("OK")) {
                    Log.d(TAG, "OK status returned");
                    Object result = map.get("result");

                    System.out.println("Object type: "+result.getClass());
                    //Map<?, ?> deviceMap = gson.fromJson(new JsonReader(new BufferedReader(Arra)))
                    ArrayList aList = (ArrayList) map.get("result");
                    Log.d(TAG, "Size of arrayList = "+ aList.size());
                    Map<?,?> ooo = (Map<?, ?>) aList.get(0);
                    System.out.println(ooo);
                    String devType = (String)ooo.get("Type");
                    System.out.println("The device is of type "+devType);

                }
                //String result = (String)map.get("result");
                //System.out.println("Result = "+result);
                //return new Gson().fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")), TempHumDeviceAnswer.class);
*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DomoticzInstance getDomoticzInfo(String urlname) {
        try {
            Log.d(TAG, "getting info");
            final HttpURLConnection connection = getHttpUrlConnection(BASE_URL + "?type=command&param=getversion");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/json");

            final int responseCode = connection.getResponseCode();
            Log.d(TAG,"Response code "+responseCode);
            // If success
            if (responseCode == 200) {
                // Build our Response
/*
                InputStream input = connection.getInputStream();
                int bytes = input.available();
                System.out.println("There are "+bytes+" bytes available");
                byte[] array = new byte[5000];
                input.read(array);
                String data = new String(array, "UTF-8");
                System.out.println("Data read:");
                System.out.println(data);
                //input.close();
                //return new Gson().fromJson(data, DomoticzInstance.class);
                //return new Gson().fromJson(new JsonReader(new InputStreamReader(new ByteArrayInputStream(array), "UTF-8")), DomoticzInstance.class);
*/
                return new Gson().fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")), DomoticzInstance.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getUserProfile(String userName, final GetResponseCallback callback) {

    }

    static void GetAuthorisation(String username, String password) {
        //HttpClient client =  new HttpClient();
        //HttpPost
    }

    private String getB64Auth (String login, String pass) {
        String source=login+":"+pass;
        String ret="Basic "+ Base64.encodeToString(source.getBytes(),Base64.URL_SAFE|Base64.NO_WRAP);
        return ret;
    }

    private static DmcAuthenticated getDomoticzAuthentication(String base64encoded) throws Exception {
        // Create a HTTP Post to twitter platform
        final HttpURLConnection conn = getHttpUrlConnection(BASE_URL);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Authorization", "Basic " + base64encoded);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        // Send post request
        conn.setDoOutput(true);
        final DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes("grant_type=client_credentials");
        wr.flush();
        wr.close();

        final int responseCode = conn.getResponseCode();
        // If success
        if (responseCode == 200){
            // Read the response, and build the TwitterAuthenticated object
            final DmcAuthenticated authenticated = new Gson().fromJson(new JsonReader(new InputStreamReader(conn.getInputStream(), "UTF-8")), DmcAuthenticated.class);
            return authenticated;
        }

        return null;

    }

    private static HttpURLConnection getHttpUrlConnection(String url) throws Exception {
        Log.d(TAG, url);
        return (HttpURLConnection) new URL(url).openConnection();
    }

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    //@GET("marvel")
    //Call<List<TempHum>> getHeroes();

}
