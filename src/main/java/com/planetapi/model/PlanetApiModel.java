package com.planetapi.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetApiModel {
    private Integer count;
    private String next;
    private String previous;
    private List<PlanetDto> results = new ArrayList<PlanetDto>();

    public PlanetApiModel() {
    }

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<PlanetDto> getResults() {
        return results;
    }
}
