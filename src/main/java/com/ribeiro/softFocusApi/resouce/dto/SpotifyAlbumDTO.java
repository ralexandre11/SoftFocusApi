package com.ribeiro.softFocusApi.resouce.dto;

import java.util.List;

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
public class SpotifyAlbumDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("items")
    private List<SpotifyItemDTO> items;
}
