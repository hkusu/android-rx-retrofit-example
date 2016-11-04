package io.github.hkusu.rxRetrofit;

import com.google.gson.annotations.SerializedName;

public class QiitaItemUser {
    @SerializedName("id")
    public int id;

    @SerializedName("url_name")
    public String urlName;

    @SerializedName("profile_image_url")
    public String profileImageUrl;
}
