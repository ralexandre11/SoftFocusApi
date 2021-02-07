package com.ribeiro.softFocusApi.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogRequest implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_requestr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "date")
	private String date;

}