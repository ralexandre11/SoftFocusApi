package com.ribeiro.softFocusApi.service;

import com.ribeiro.softFocusApi.model.resouce.dto.ResponseWeatherDTO;

public interface OpenWeatherMapsService {

	ResponseWeatherDTO callOpenweathermapAPI(String city);
	
}
