package com.ribeiro.softFocusApi.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.softFocusApi.model.entity.LogRequest;
import com.ribeiro.softFocusApi.service.LogRequestService;

import lombok.RequiredArgsConstructor;

/**
 * Classe responsável por disponibilizar o endpoint /api/logrequest
 * Chamada: http://localhost:8080/api/logrequest
 * 
 * @author Ricardo Ribeiro
 * @since 07/02/2021 
 */
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
