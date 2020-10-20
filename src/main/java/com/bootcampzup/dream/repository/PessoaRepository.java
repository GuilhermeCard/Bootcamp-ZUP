package com.bootcampzup.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampzup.dream.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
