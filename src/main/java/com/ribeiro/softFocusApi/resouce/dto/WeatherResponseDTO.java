package com.ribeiro.softFocusApi.resouce.dto;

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
public class WeatherResponseDTO {
	
	@JsonProperty("name")
	private String city;

	@JsonProperty("coord")
	private WeatherCoordDTO coord;

	@JsonProperty("main")
	private WeatherMainDTO main;
		
}
