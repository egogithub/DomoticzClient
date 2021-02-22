package com.worldline.domoticzclient.pojo;

import com.google.gson.annotations.SerializedName;

public class DomoticzInstance {
    @SerializedName("DomoticzUpdateURL")
    public String dmUpdateUrl;

    @SerializedName("HaveUpdate")
    public Boolean haveUpdate; //": false,

    @SerializedName("Revision")
    public int rev; //": 9540,

    @SerializedName("SystemName")
    public String systemName;//": "linux",

    @SerializedName("UseUpdate")
    public Boolean useUpdate; //": true,

    @SerializedName("build_time")
    public String build_time; //": "2018-05-29 14:27:24",

    @SerializedName("dzvents_version")
    public String dzvents_version; //": "2.4.6",

    @SerializedName("hash")
    public String hash; //": "30295913",

    @SerializedName("python_version")
    public String python_version; //": "3.5.3 (default, Jan 19 2017, 14:11:04) \n[GCC 6.3.0 20170124]",

    @SerializedName("status")
    public String status; //": "OK",

    @SerializedName("title")
    public String title; //": "GetVersion",

    @SerializedName("version")
    public String version; //": "3.9530"
}
