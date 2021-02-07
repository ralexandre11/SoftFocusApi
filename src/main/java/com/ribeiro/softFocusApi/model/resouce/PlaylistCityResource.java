package com.ribeiro.softFocusApi.model.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.softFocusApi.model.resouce.dto.CityWeatherDTO;
import com.ribeiro.softFocusApi.service.OpenWeatherMapsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/playlist")
@RequiredArgsConstructor
public class PlaylistCityResource {
	
	@Autowired
	private final OpenWeatherMapsService service;
	
	@GetMapping(value = "/{city}")
	public ResponseEntity<CityWeatherDTO> checkWeather(@PathVariable final String city) {
		CityWeatherDTO dto = new CityWeatherDTO();
		dto = service.callOpenweathermapAPI(city);
		return ResponseEntity.ok().body(dto);
	}

	

}
