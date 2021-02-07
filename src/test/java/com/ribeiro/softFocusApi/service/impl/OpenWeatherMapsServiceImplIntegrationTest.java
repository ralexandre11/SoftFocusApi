package com.ribeiro.softFocusApi.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ribeiro.softFocusApi.model.resouce.dto.ResponseWeatherDTO;

public class OpenWeatherMapsServiceImplIntegrationTest {
	
	OpenWeatherMapsServiceImpl service = new OpenWeatherMapsServiceImpl();
	
	@Test
	public void givenCity_whenCallApi_thenCreateResponseDTO() {
		// given
		String city = "Recife";

		// when
		final ResponseWeatherDTO responseDTO = service.callOpenweathermapAPI(city);

		// then
		Assertions.assertThat(responseDTO.getCity())
			.isEqualTo(city);
		Assertions.assertThat(responseDTO.getCoord().getLon())
			.isEqualTo("-34.8811");
	}
	

}
