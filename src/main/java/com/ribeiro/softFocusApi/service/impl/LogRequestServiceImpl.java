package com.ribeiro.softFocusApi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.model.exception.PersonalException;
import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;
import com.ribeiro.softFocusApi.model.resouce.dto.WeatherResponseDTO;
import com.ribeiro.softFocusApi.service.LogRequestService;

@Service
public class LogRequestServiceImpl implements LogRequestService {

	private LogRequestRepository repository;

	public LogRequestServiceImpl(LogRequestRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<LogRequest> all() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public LogRequest Save(WeatherResponseDTO weatherDTO) {
		checkWeatherDTO(weatherDTO);
		
		Double tempCelcius = weatherDTO.getMain().getTemp() - 273.0; 
		LogRequest logRequest = new LogRequest();
		logRequest.setDate(new Date());
		logRequest.setCity(weatherDTO.getCity());
		logRequest.setLon(weatherDTO.getCoord().getLon());
		logRequest.setLat(weatherDTO.getCoord().getLat());
		logRequest.setTemp(tempCelcius);
		logRequest.setGenre(verifyGenre(tempCelcius));
		
		return repository.save(logRequest);
	}

	private void checkWeatherDTO(WeatherResponseDTO weatherDTO) {
		if (weatherDTO.getCity() == null) {
			throw new PersonalException("Cidade não localizada!");
		}
	}
	
	public String verifyGenre(Double tempCelcius) {
		String genre = new String();
		
		if (tempCelcius > 30.0) {
			genre = "party";
		} else if (tempCelcius > 15.0) {
			genre = "pop";
		} else if (tempCelcius > 10.0) {
			genre = "rock";
		} else {
			genre = "classical";
		}
		return genre;
	}
	
	
	
}
