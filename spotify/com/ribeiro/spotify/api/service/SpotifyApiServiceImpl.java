package com.ribeiro.spotify.api.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.ribeiro.spotify.api.dto.Album;
import com.ribeiro.spotify.api.dto.Recomendation;
import com.ribeiro.spotify.api.dto.Token;

import lombok.NoArgsConstructor;

/**
 * Classe que implementa a API do Spotfy (https://developer.spotify.com/documentation/web-api/)
 * 
 * @author Ricardo Ribeiro
 * @since 07/02/2021
 *
 */
@Service
public class SpotifyApiServiceImpl implements SpotifyApiService {
	
//	private static SpotifyApiImpl unique;
	
	private Token token;
	
	private final static String client_id="efa6a305ca004ac0947bb74161223d66";
	private final static String client_secret="a9a02107496f46bd9ef2c5f7470a1b46";
	private final static String redirect_url="http://localhost:8080/callback";
	
	/**
	 * Retorna o client_id e client_secret no padrão Base64
	 * @return
	 */
	private static String getEncoded64() {
		return Base64.getEncoder().encodeToString((client_id+":"+client_secret).getBytes());
	}
	
	/**
	 * Método responsável por obter uma autorização de acesso
	 * @return
	 */
	@Override
	public String getAuthorizationUrl() {
		// https://accounts.spotify.com/authorize?response_type=code&redirect_uri=http://localhost:8080/callback&client_id=efa6a305ca004ac0947bb74161223d66
		return String.format("https://accounts.spotify.com/authorize?response_type=code&redirect_uri=%s&client_id=%s", redirect_url, client_id);
	}
	
	/**
	 * Método responsável por retornar um Token de acess à API do Spotfy
	 */
	@Override
	public Token getToken() {
		if(token != null) {
			return token;
		}
		final String url = "https://accounts.spotify.com/api/token";
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.add("Authorization", "Basic "+getEncoded64());

			MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
			map.add("grant_type", "client_credentials");
			
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
			token = restTemplate.postForObject( url, request , Token.class );
			return token;
		} catch (HttpStatusCodeException e) {
			ResponseEntity response = new ResponseEntity<String>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
			throw e;
		}
	}

	/**
	 * Método responsável por retornar o cabeçalho preenchido com a autorização
	 * @param autorization
	 * @return
	 */
	private HttpEntity<?> getEntityAutorization(String autorization) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer "+autorization);
        
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
	}

	/**
	 * Método que retorna a recomendação de album
	 */
	@Override
	public Recomendation getRecomendations(String autorization, String genres) {
		final String url = String.format("https://api.spotify.com/v1/recommendations?market=US&seed_genres=%s&limit=1", genres);

	    RestTemplate restTemplate = new RestTemplate();
	    try {
	    	
	        ResponseEntity<Recomendation> response = restTemplate.exchange(url, HttpMethod.GET, getEntityAutorization(autorization), Recomendation.class);
	        return response.getBody();
	    } catch (HttpStatusCodeException e) {
			ResponseEntity response = new ResponseEntity<String>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
			// TODO Implementar algum tratamento
			throw e;
		}
	}

	/**
	 * Método responsável por retornar as músicas de um album
	 */
	@Override
	public Album getTracks(String autorization, String albumId) {
		final String url = String.format("https://api.spotify.com/v1/albums/%s/tracks", albumId);

	    RestTemplate restTemplate = new RestTemplate();
	    try {
	    	
	        ResponseEntity<Album> response = restTemplate.exchange(url, HttpMethod.GET, getEntityAutorization(autorization), Album.class);
	        return response.getBody();
	    } catch (HttpStatusCodeException e) {
			ResponseEntity response = new ResponseEntity<String>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
			// TODO Implementar algum tratamento
			throw e;
		}
	}

	@Override
	public boolean tokenIsNull() {
		return token==null;
	}

}

