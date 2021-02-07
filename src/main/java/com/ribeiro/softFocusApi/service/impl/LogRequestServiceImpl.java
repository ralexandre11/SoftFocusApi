package com.ribeiro.softFocusApi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.model.exception.PersonalException;
import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;
import com.ribeiro.softFocusApi.model.resouce.dto.ResponseWeatherDTO;
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
	public LogRequest Save(ResponseWeatherDTO weatherDTO) {
		checkWeatherDTO(weatherDTO);
		
		Double tempCelcius
		LogRequest logRequest = new LogRequest();
		logRequest.setDate(new Date());
		logRequest.setCity(weatherDTO.getCity());
		logRequest.setLon(weatherDTO.getCoord().getLon());
		logRequest.setLat(weatherDTO.getCoord().getLat());
		logRequest.setTemp(weatherDTO.getMain().getTemp());
		logRequest.setGenre(verifyGenre(weatherDTO.getMain().getTemp()));
		
		return repository.save(logRequest);
	}

	private void checkWeatherDTO(ResponseWeatherDTO weatherDTO) {
		if (weatherDTO.getCity() == null) {
			throw new PersonalException("Cidade não localizada!");
		}
	}
	
	private String verifyGenre(Double temp) {
		String genre = new String();
		
		Double tempCelcius = temp - 273.0;
		
		if (tempCelcius > 30.0) {
			gen
		}
		return genre;
	}
	
}
