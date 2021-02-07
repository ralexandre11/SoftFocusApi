package com.ribeiro.softFocusApi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ribeiro.softFocusApi.model.entity.LogRequest;

public interface LogRequestRepository extends JpaRepository<LogRequest, Long>{

}