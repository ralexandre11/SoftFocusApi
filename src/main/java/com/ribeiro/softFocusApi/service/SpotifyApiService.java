package com.ribeiro.softFocusApi.service;

import java.util.List;

import com.ribeiro.softFocusApi.model.resouce.dto.SpotifyAlbumDTO;
import com.ribeiro.softFocusApi.model.resouce.dto.SpotifyItemDTO;
import com.ribeiro.softFocusApi.model.resouce.dto.SpotifyRecomendationDTO;
import com.ribeiro.softFocusApi.model.resouce.dto.SpotifyTokenDTO;

public interface SpotifyApiService {

	/**
	 * Método responsável por obter uma autorização de acesso
	 * 
	 * @return
	 */
	public String getAuthorizationUrl();

	/**
	 * Método responsável por retornar um Token de acess à API do Spotfy
	 */
	public SpotifyTokenDTO getToken();

	/**
	 * Método que retorna a recomendação de album
	 */
	public SpotifyRecomendationDTO getRecomendations(String token, String genres);

	/**
	 * Método responsável por retornar as músicas de um album
	 */
	public SpotifyAlbumDTO getAlbumItems(String token, String albumId) ;
	
	public List<SpotifyItemDTO> getTracks(String genre);

	public boolean tokenIsNull();
	
}
