package com.worldline.domoticzclient.pojo;

import java.util.ArrayList;

public class LightSwitchDevice {
    private int AddjMulti; //: 1,
    private int AddjMulti2; //: 1,
    private int AddjValue; //: 0,
    private int AddjValue2; //: 0,
    private int BatteryLevel; //: 255,
    private int CustomImage; //: 0,
    private String Data; //: "Off",
    private String Description; //: "",
    private String DimmerType; //: "none",
    private int Favorite; //: 0,
    private int HardwareID; //: 2,
    private String HardwareName; //: "RFLink",
    private String HardwareType; //: "RFLink Gateway USB",
    private int HardwareTypeVal; //: 46,
    private Boolean HaveDimmer; //: false,
    private Boolean HaveGroupCmd; //: false,
    private Boolean HaveTimeout; //: false,
    private String ID; //: "001F93AE",
    private String Image; //: "Light",
    private Boolean IsSubDevice; //: false,
    private String LastUpdate; //: "2021-02-22 10:30:46",
    private int Level; //: 0,
    private int LevelInt; //: 0,
    private int MaxDimLevel; //: 100,
    private String Name; //: "Unknown",
    private Boolean Notifications; //: "false",
    private String PlanID; //: "0",
    private ArrayList<Integer> PlanIDs; //: [ 0 ],
    private Boolean Protected; //: false,
    private Boolean ShowNotifications; //: true,
    private String SignalLevel; //: "-",
    private String Status; //: "Off",
    private String StrParam1; //: "",
    private String StrParam2; //: "",
    private String SubType; //: "Atlantic",
    private String SwitchType; //: "On/Off",
    private int SwitchTypeVal; //: 0,
    private String Timers; //: "false",
    private String Type; //: "Light/Switch",
    private String TypeImg; //: "lightbulb",
    private int Unit; //: 1,
    private int Used; //: 0,
    private Boolean UsedByCamera; //: false,
    private String XOffset; //: "0",
    private String YOffset; //: "0",
    private String idx; //: "2"

    public String getData() {
        return Data;
    }

    public String getStatus() {
        return Status;
    }

    public String getSwitchType() {
        return SwitchType;
    }

    public int getSwitchTypeVal() {
        return SwitchTypeVal;
    }

    public String getType() {
        return Type;
    }

    public String getTypeImg() {
        return TypeImg;
    }

    public int getUsed() {
        return Used;
    }
}
