package com.ribeiro.softFocusApi.service;

import java.util.List;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.resouce.dto.WeatherResponseDTO;

public interface LogRequestService {
	
	List<LogRequest> all();
	
	LogRequest Save(WeatherResponseDTO weatherDTO);
	
	String verifyGenre(Double temp);

}
