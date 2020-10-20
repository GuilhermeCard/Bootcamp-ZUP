package com.bootcampzup.dream.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "foto_name")
@Entity
public class FotoCpf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_foto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFoto;

	private String name;

	public FotoCpf() {

	}

	public FotoCpf(Long idFoto, String name) {
		this.idFoto = idFoto;
		this.name = name;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
