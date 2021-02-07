package com.ribeiro.softFocusApi.model.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.service.LogRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/logrequest")
@RequiredArgsConstructor
public class LogRequestResource {

	@Autowired
	private final LogRequestService service;

	@GetMapping
	public ResponseEntity<List<LogRequest>> findAll() {
		final List<LogRequest> requests = service.all();
		return ResponseEntity.ok().body(requests);
	}
	
	
}
