package com.example.yanal.knowyourhero.Marvel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaMarvelCharacter {

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

}