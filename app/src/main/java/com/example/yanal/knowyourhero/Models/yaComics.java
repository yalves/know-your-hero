package com.example.yanal.knowyourhero.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaComics implements Parcelable {

    private Integer available;
    private String collectionURI;
    private List<Object> items = null;
    private Integer returned;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    protected yaComics(Parcel in) {
        available = in.readByte() == 0x00 ? null : in.readInt();
        collectionURI = in.readString();
        if (in.readByte() == 0x01) {
            items = new ArrayList<Object>();
            in.readList(items, Object.class.getClassLoader());
        } else {
            items = null;
        }
        returned = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (available == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(available);
        }
        dest.writeString(collectionURI);
        if (items == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(items);
        }
        if (returned == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(returned);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<yaComics> CREATOR = new Parcelable.Creator<yaComics>() {
        @Override
        public yaComics createFromParcel(Parcel in) {
            return new yaComics(in);
        }

        @Override
        public yaComics[] newArray(int size) {
            return new yaComics[size];
        }
    };
}