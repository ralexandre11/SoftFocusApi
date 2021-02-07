package com.ribeiro.softFocusApi.model.resouce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherDTO {
	
		private String city;

		private String lon;

		private String lat;
		
		private String temp;

}
