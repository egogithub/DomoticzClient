package com.worldline.domoticzclient.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TempHumidityDevice {

    private int AddjMulti; //: 1,
    private int AddjMulti2; //: 1,
    private int AddjValue; //: 0,
    private int AddjValue2; //: 0,
    @SerializedName("BatteryLevel")
    private int batteryLevel; //: 100,
    private int CustomImage; //: 0,
    @SerializedName("Data")
    private String data; //: "17.8 C, 47 %",
    @SerializedName("Description")
    private String description; //: "",
    @SerializedName("DewPoint")
    private String dewPoint; //: "6.33",
    @SerializedName("Favorite")
    private int favorite; //: 1,
    private int HardwareID; //: 2,
    private String HardwareName; //: "RFLink",
    private String HardwareType; //: "RFLink Gateway USB",
    private String HardwareTypeVal; //: 46,
    private Boolean HaveTimeout; //: false,
    @SerializedName("Humidity")
    private int humidity; //: 47,
    private String HumidityStatus; //: "Comfortable",
    private String ID; //: "2DDC",
    private String LastUpdate; //: "2021-02-19 13:15:03",
    private String Name; //: "Oregon TempHygro 1",
    private String Notifications; //: "false",
    private String PlanID; //: "0",
    private ArrayList<Integer> PlanIDs; //: [ 0 ],
    private Boolean Protected; //: false,
    private Boolean ShowNotifications; //: true,
    private String SignalLevel; //: "-",
    private String SubType; //: "WTGR800",
    private float Temp; //: 17.8,
    private String Timers; //: "false",
    @SerializedName("Type")
    private String deviceType; //: "Temp + Humidity",
    private String TypeImg; //: "temperature",
    private int Unit; //: 0,
    private int Used; //: 1,
    private String XOffset; //: "0",
    private String YOffset; //: "0",
    private String idx; //: "1",
    private int trend; //: 2

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getData() {
        return data;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getHumidityStatus() {
        return HumidityStatus;
    }

    public String getName() {
        return Name;
    }

    public float getTemp() {
        return Temp;
    }

    public String getDeviceType() {
        return deviceType;
    }
}
