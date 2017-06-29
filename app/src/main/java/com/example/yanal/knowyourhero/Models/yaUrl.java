package com.example.yanal.knowyourhero.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaUrl implements Parcelable {

    private String type;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    protected yaUrl(Parcel in) {
        type = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<yaUrl> CREATOR = new Parcelable.Creator<yaUrl>() {
        @Override
        public yaUrl createFromParcel(Parcel in) {
            return new yaUrl(in);
        }

        @Override
        public yaUrl[] newArray(int size) {
            return new yaUrl[size];
        }
    };
}