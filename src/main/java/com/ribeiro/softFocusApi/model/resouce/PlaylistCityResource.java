package com.ribeiro.softFocusApi.model.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;
import com.ribeiro.softFocusApi.model.resouce.dto.SpotifyItemDTO;
import com.ribeiro.softFocusApi.model.resouce.dto.WeatherResponseDTO;
import com.ribeiro.softFocusApi.service.LogRequestService;
import com.ribeiro.softFocusApi.service.OpenWeatherMapsService;
import com.ribeiro.softFocusApi.service.SpotifyApiService;
import com.ribeiro.softFocusApi.service.impl.SpotifyApiServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author ricardo
 *
 */
@RestController
@RequestMapping(value = "/api/playlist")
@RequiredArgsConstructor
public class PlaylistCityResource {
	
	@Autowired
	private final OpenWeatherMapsService weatherService;
	
	@Autowired
	private final SpotifyApiService SpotifyService;
	
	@Autowired
	private final LogRequestService logRequestService;
	
//	@Autowired
//	private final SpotifyApiImpl spotify;
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	@GetMapping(value = "/{city}")
	public ResponseEntity<List<SpotifyItemDTO>> checkWeather(@PathVariable final String city) {
		
		// Call Weater API
		WeatherResponseDTO weatherDTO = new WeatherResponseDTO();
		weatherDTO = weatherService.callOpenweathermapAPI(city);
		// Save Log Request
		LogRequest logRequest = logRequestService.Save(weatherDTO);
		
		// Call Spotify API to get Tracks
		final String genre = logRequest.getGenre(); 
		final List<SpotifyItemDTO> spotifyTracks = SpotifyService.getTracks(genre);
		
		return ResponseEntity.ok().body(spotifyTracks);
	}

	

}
