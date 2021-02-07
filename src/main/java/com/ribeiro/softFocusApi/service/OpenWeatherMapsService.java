package com.ribeiro.softFocusApi.service;

import com.ribeiro.softFocusApi.model.resouce.dto.CityWeatherDTO;

public interface OpenWeatherMapsService {

	CityWeatherDTO callOpenweathermapAPI(String city);
	
}
