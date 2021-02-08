package com.ribeiro.softFocusApi.model.resouce;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.spotify.api.dto.Token;
import com.ribeiro.spotify.api.service.SpotifyApiServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CallBackSpotifyResource {
	
	SpotifyApiServiceImpl spotify = SpotifyApiServiceImpl.getInstance();

	@RequestMapping(value = "/callback/{code}", method = RequestMethod.GET)
	public ResponseEntity<Token> callback(@PathVariable final String code) {
		
		Token token = spotify.getToken(code);
		
		System.out.println(token);
		return ResponseEntity.ok().body(token);
	}
	
}
