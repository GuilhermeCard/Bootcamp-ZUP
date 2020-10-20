package com.bootcampzup.dream.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcampzup.dream.model.Endereco;
import com.bootcampzup.dream.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> findAllEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco findById(Long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.get();
	}

	public Endereco insert(Endereco obj) {
		return enderecoRepository.save(obj);
	}

}
