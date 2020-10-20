package com.bootcampzup.dream.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcampzup.dream.model.FotoCpf;
import com.bootcampzup.dream.repository.FotoCpfRepository;

@Service
public class FotoCpfService {
	@Autowired
	FotoCpfRepository fotoCpfRepository;

	public FotoCpf findById(Long id) {
		Optional<FotoCpf> obj = fotoCpfRepository.findById(id);
		return obj.get();
	}

	public FotoCpf insert(FotoCpf obj) {
		return fotoCpfRepository.save(obj);
	}

}
