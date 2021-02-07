package com.ribeiro.softFocusApi.service.impl;

import java.util.List;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.model.repository.LogRequestRepository;
import com.ribeiro.softFocusApi.service.LogRequestService;

public class LogRequestServiceImpl implements LogRequestService {

	private LogRequestRepository repository;

	public LogRequestServiceImpl(LogRequestRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<LogRequest> all() {
		return repository.findAll();
	}

	
}
