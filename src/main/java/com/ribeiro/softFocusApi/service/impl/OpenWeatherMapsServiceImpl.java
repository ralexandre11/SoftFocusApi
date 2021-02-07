package com.ribeiro.softFocusApi.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ribeiro.softFocusApi.model.resouce.dto.CityWeatherDTO;
import com.ribeiro.softFocusApi.service.OpenWeatherMapsService;

@Service
public class OpenWeatherMapsServiceImpl implements OpenWeatherMapsService {

	@Override
	public CityWeatherDTO callOpenweathermapAPI(String city) {
		//http://api.openweathermap.org/data/2.5/weather?q=recife&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af
		final String uri = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}";
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("city", city);
		params.put("key", "6801fe9e74c3fd9d5a5b0ea6b668d7af");
		
		return restTemplate.getForObject(uri, CityWeatherDTO.class, params);
	}

}
