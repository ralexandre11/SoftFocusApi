package com.ribeiro.softFocusApi.resouce.dto;

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
public class WeatherMainDTO {

	private Double temp;
	private Integer humidity;
	
}
