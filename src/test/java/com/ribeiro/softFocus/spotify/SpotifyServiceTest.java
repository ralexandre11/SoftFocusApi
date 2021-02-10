package com.ribeiro.softFocus.spotify;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ribeiro.softFocusApi.resouce.dto.SpotifyAlbumDTO;
import com.ribeiro.softFocusApi.resouce.dto.SpotifyRecomendationDTO;
import com.ribeiro.softFocusApi.resouce.dto.SpotifyTokenDTO;
import com.ribeiro.softFocusApi.resouce.dto.SpotifyTrackDTO;
import com.ribeiro.softFocusApi.service.impl.SpotifyApiServiceImpl;

public class SpotifyServiceTest {

	SpotifyApiServiceImpl service = new SpotifyApiServiceImpl();
	
	@Test
	public void whenGetToken_thenRetunValidToken() {
		// given

		// when
		final SpotifyTokenDTO token = service.getToken();

		// then
		Assertions.assertThat(token.getAccessToken()).isNotEmpty();
		Assertions.assertThat(token.getTokenType()).isEqualTo("Bearer");	
	}

	@Test
	public void givenGenreRock_whenGetRecomedation_thenAlbumExist() {
		// given
		final String token = service.getToken().getAccessToken();
		final String genre = "rock";
		
		// when
		final SpotifyRecomendationDTO responseRecomendationDTO = service.getRecomendations(token, genre);
		final List<SpotifyTrackDTO> tracks = responseRecomendationDTO.getTracks();
		final SpotifyAlbumDTO album = tracks.get(0).getAlbum();

		// then
		Assertions.assertThat(album.getId()).isNotEmpty();
	}

	@Test
	public void givenAlbumId_whenGetTracks_thenSizeIsGreaterZERO() {
		// given
		final String token = service.getToken().getAccessToken();
		final String AlbumId = "7HL8ZuakXsPF3XxmKaxIoz";
		final SpotifyAlbumDTO album = new SpotifyAlbumDTO(AlbumId, null);
		
		// when
		album.setItems(service.getAlbumItems(token, album.getId()).getItems());
		
		System.out.println(album.getItems());

		// then
		Assertions.assertThat(album.getItems().size()).isGreaterThan(0);
	}

	
}
