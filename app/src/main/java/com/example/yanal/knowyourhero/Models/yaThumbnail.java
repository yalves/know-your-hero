package com.example.yanal.knowyourhero.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaThumbnail implements Parcelable {

    private String path;
    private String extension;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    protected yaThumbnail(Parcel in) {
        path = in.readString();
        extension = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(extension);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<yaThumbnail> CREATOR = new Parcelable.Creator<yaThumbnail>() {
        @Override
        public yaThumbnail createFromParcel(Parcel in) {
            return new yaThumbnail(in);
        }

        @Override
        public yaThumbnail[] newArray(int size) {
            return new yaThumbnail[size];
        }
    };
}