package com.ribeiro.softFocusApi.model.resouce.dto;

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
public class ResponseWeatherDTO {
	
	@JsonProperty("name")
	private String city;

	@JsonProperty("coord")
	private CoordWeatherDTO coord;

	@JsonProperty("main")
	private MainWeatherDTO main;
		
}
