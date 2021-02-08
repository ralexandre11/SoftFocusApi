package com.ribeiro.spotify.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    @JsonProperty("id")
    private String id;

    @JsonProperty("track_number")
    private Integer number;

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("duration_ms")
    private Long duration;

}
