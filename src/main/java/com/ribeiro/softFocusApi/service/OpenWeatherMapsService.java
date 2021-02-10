package com.ribeiro.softFocusApi.service;

import com.ribeiro.softFocusApi.resouce.dto.WeatherResponseDTO;

public interface OpenWeatherMapsService {

	WeatherResponseDTO callOpenweathermapAPI(String city);
	
}
