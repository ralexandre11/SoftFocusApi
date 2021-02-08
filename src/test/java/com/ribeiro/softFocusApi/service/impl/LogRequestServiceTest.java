package com.ribeiro.softFocusApi.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;

@ExtendWith(MockitoExtension.class)
public class LogRequestServiceTest {

	@Mock
	LogRequestRepository repositoryMock;

	LogRequestServiceImpl service;

	@BeforeEach
	public void setup() {
		service = new LogRequestServiceImpl(repositoryMock);
	}
	
	
	@Test
	public void givenTemperature13_whenVerifyGenre_thenGenreISRock() {
		// given
		Double temp = 13.0;

		// when
		final String genre = service.verifyGenre(temp);

		// then
		Assertions.assertThat(genre).isEqualTo("rock");
	}
	

	
}
