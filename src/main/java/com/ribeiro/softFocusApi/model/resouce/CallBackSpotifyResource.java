package com.ribeiro.softFocusApi.model.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.spotify.api.dto.Token;
import com.ribeiro.spotify.api.service.SpotifyApiServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/callback")
public class CallBackSpotifyResource {
	
//	@Autowired
//	private final SpotifyApiServiceImpl spotify;

//	@GetMapping
//	public ResponseEntity<String> testCallback() {
//		final String testResponse = new String("OK");
//		return ResponseEntity.ok().body(testResponse);
//	}
	
//	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<Token> callback(@RequestParam(defaultValue = "empty") String code) {
		
		Token token = new Token();
		
//		System.out.printf("Code: %s", code);
//		System.out.printf("Token: %s", token);
		return ResponseEntity.ok().body(token);
	}
	
}
