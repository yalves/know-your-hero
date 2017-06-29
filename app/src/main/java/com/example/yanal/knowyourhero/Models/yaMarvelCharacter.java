package com.example.yanal.knowyourhero.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaMarvelCharacter implements Parcelable {

    private Integer id;
    private String name;
    private String description;
    private String modified;
    private yaThumbnail thumbnail;
    private String resourceURI;
    private yaComics comics;
    private yaSeries series;
    private yaStories stories;
    private yaEvents events;
    private List<yaUrl> urls = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public yaThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(yaThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public yaComics getComics() {
        return comics;
    }

    public void setComics(yaComics comics) {
        this.comics = comics;
    }

    public yaSeries getSeries() {
        return series;
    }

    public void setSeries(yaSeries series) {
        this.series = series;
    }

    public yaStories getStories() {
        return stories;
    }

    public void setStories(yaStories stories) {
        this.stories = stories;
    }

    public yaEvents getEvents() {
        return events;
    }

    public void setEvents(yaEvents events) {
        this.events = events;
    }

    public List<yaUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<yaUrl> urls) {
        this.urls = urls;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getSmallThumbnailUrl() {
        return this.getThumbnail().getPath() + "/standard_small." + this.getThumbnail().getExtension();
    }

    public String getIncredibleThumbnailUrl() {
        return this.getThumbnail().getPath() + "/landscape_incredible." + this.getThumbnail().getExtension();
    }

    protected yaMarvelCharacter(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
        description = in.readString();
        modified = in.readString();
        thumbnail = (yaThumbnail) in.readValue(yaThumbnail.class.getClassLoader());
        resourceURI = in.readString();
        comics = (yaComics) in.readValue(yaComics.class.getClassLoader());
        series = (yaSeries) in.readValue(yaSeries.class.getClassLoader());
        stories = (yaStories) in.readValue(yaStories.class.getClassLoader());
        events = (yaEvents) in.readValue(yaEvents.class.getClassLoader());
        if (in.readByte() == 0x01) {
            urls = new ArrayList<yaUrl>();
            in.readList(urls, yaUrl.class.getClassLoader());
        } else {
            urls = null;
        }
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest,int flags){
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeValue(thumbnail);
        dest.writeString(resourceURI);
        dest.writeValue(comics);
        dest.writeValue(series);
        dest.writeValue(stories);
        dest.writeValue(events);
        if (urls == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(urls);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<yaMarvelCharacter> CREATOR = new Parcelable.Creator<yaMarvelCharacter>() {
        @Override
        public yaMarvelCharacter createFromParcel(Parcel in) {
            return new yaMarvelCharacter(in);
        }

        @Override
        public yaMarvelCharacter[] newArray(int size) {
            return new yaMarvelCharacter[size];
        }
    };
}
