package com.ribeiro.softFocusApi.service;

import java.util.List;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.model.resouce.dto.ResponseWeatherDTO;

public interface LogRequestService {
	
	List<LogRequest> all();
	
	LogRequest Save(ResponseWeatherDTO weatherDTO);

}
