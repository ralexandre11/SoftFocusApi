package com.ribeiro.softFocusApi.model.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;
import com.ribeiro.softFocusApi.model.resouce.dto.ResponseWeatherDTO;
import com.ribeiro.softFocusApi.service.LogRequestService;
import com.ribeiro.softFocusApi.service.OpenWeatherMapsService;
import com.ribeiro.spotify.api.service.SpotifyApiServiceImpl;

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
	private final OpenWeatherMapsService Weaterservice;
	
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
	public ResponseEntity<LogRequestRepository> checkWeather(@PathVariable final String city) {
		ResponseWeatherDTO responseDTO = new ResponseWeatherDTO();
		// Call API
		responseDTO = Weaterservice.callOpenweathermapAPI(city);
		// Save Log Request
		LogRequestRepository logRequest = (LogRequestRepository) logRequestService.Save(responseDTO);
		
//		if(spotify.tokenIsNull()) {
//			// redirect	spotify.getAuthorizationUrl()
//		}
		return ResponseEntity.ok().body(logRequest);
	}

	

}
