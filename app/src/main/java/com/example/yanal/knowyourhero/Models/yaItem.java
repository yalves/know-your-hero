package com.example.yanal.knowyourhero.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaItem implements Parcelable {

    private String resourceURI;
    private String name;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    protected yaItem(Parcel in) {
        resourceURI = in.readString();
        name = in.readString();
        type = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resourceURI);
        dest.writeString(name);
        dest.writeString(type);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<yaItem> CREATOR = new Parcelable.Creator<yaItem>() {
        @Override
        public yaItem createFromParcel(Parcel in) {
            return new yaItem(in);
        }

        @Override
        public yaItem[] newArray(int size) {
            return new yaItem[size];
        }
    };
}
