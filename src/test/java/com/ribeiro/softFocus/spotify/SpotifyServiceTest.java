package com.ribeiro.softFocus.spotify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ribeiro.spotify.api.dto.Token;
import com.ribeiro.spotify.api.service.SpotifyApiServiceImpl;

public class SpotifyServiceTest {

	SpotifyApiServiceImpl service = new SpotifyApiServiceImpl();
	
	@Test
	public void givenCity_whenCallApi_thenCreateResponseDTO() {
		// given

		// when
		final Token token = service.getToken();
		System.out.println(token);

		// then
		Assertions.assertThat(token.getAccessToken()).isNotEmpty();
		Assertions.assertThat(token.getTokenType()).isEqualTo("Bearer");
		
	}
	
}
