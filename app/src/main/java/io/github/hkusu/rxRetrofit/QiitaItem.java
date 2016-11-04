package io.github.hkusu.rxRetrofit;

import com.google.gson.annotations.SerializedName;

public class QiitaItem {
    @SerializedName("id")
    public int id;

    @SerializedName("uuid")
    public String uuid;

    @SerializedName("title")
    public String title;

    @SerializedName("url")
    public String url;

    @SerializedName("user")
    public QiitaItemUser user;
}
