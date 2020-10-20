package com.bootcampzup.dream.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcampzup.dream.model.Pessoa;
import com.bootcampzup.dream.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAllPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.get();
	}

	public Pessoa insert(Pessoa obj) {
		return pessoaRepository.save(obj);
	}

}
