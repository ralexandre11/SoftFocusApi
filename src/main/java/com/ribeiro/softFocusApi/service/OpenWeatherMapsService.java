package com.ribeiro.softFocusApi.service;

import com.ribeiro.softFocusApi.model.resouce.dto.WeatherResponseDTO;

public interface OpenWeatherMapsService {

	WeatherResponseDTO callOpenweathermapAPI(String city);
	
}
