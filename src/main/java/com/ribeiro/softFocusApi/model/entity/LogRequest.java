package com.ribeiro.softFocusApi.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogRequest implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_requestr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "city")
	private String city;

	@Column(name = "log")
	private String lon;

	@Column(name = "lat")
	private String lat;
	
	@Column(name = "temp")
	private String temp;

	@Column(name = "genre")
	private String genre;

}