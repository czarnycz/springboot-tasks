package com.example.spot.model2;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.example.spot.model.Artists;
import com.example.spot.model.Track;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "artists",
        "tracks"
})
@Generated("jsonschema2pojo")
public class SpotifyTrack {

    @JsonProperty("artists")
    private Artists artists;
    @JsonProperty("tracks")
    private Track track;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("artists")
    public Artists getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    @JsonProperty("tracks")
    public Track getTrack() {
        return track;
    }

    @JsonProperty("tracks")
    public void setTrack(Track track) {
        this.track = track;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}