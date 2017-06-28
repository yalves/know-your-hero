
package com.example.yanal.knowyourhero.Marvel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaStories {

    private Integer available;
    private String collectionURI;
    private List<yaItem> items = null;
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

    public List<yaItem> getItems() {
        return items;
    }

    public void setItems(List<yaItem> items) {
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

}