package com.ribeiro.softFocusApi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ribeiro.softFocusApi.model.resouce.dto.WeatherResponseDTO;
import com.ribeiro.softFocusApi.service.OpenWeatherMapsService;

@Service
public class OpenWeatherMapsServiceImpl implements OpenWeatherMapsService {
	
	@Override
	public WeatherResponseDTO callOpenweathermapAPI(String city) {
		final String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af";
		
		RestTemplate restTemplate = new RestTemplate();
		WeatherResponseDTO responseDTO = restTemplate.getForObject(url, WeatherResponseDTO.class, city);

		System.out.println(responseDTO);
				
		return responseDTO;
	}

}
