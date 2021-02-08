package com.ribeiro.spotify.api.service;

import com.ribeiro.spotify.api.dto.Album;
import com.ribeiro.spotify.api.dto.Recomendation;
import com.ribeiro.spotify.api.dto.Token;

public interface SpotfyApiService {

	/**
	 * Método responsável por obter uma autorização de acesso
	 * 
	 * @return
	 */
	public String getAuthorizationUrl();

	/**
	 * Método responsável por retornar um Token de acess à API do Spotfy
	 */
	public Token getToken(String autorization);

	/**
	 * Método que retorna a recomendação de album
	 */
	public Recomendation getRecomendations(String autorization, String genres);

	/**
	 * Método responsável por retornar as músicas de um album
	 */
	public Album getTracks(String autorization, String albumId);

	public boolean tokenIsNull();

}