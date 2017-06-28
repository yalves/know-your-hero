package com.example.yanal.knowyourhero.Marvel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanal on 27-Jun-17.
 */

public class yaUrl {

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

}