package com.bootcampzup.dream.resource;

import java.net.URI;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcampzup.dream.model.Pessoa;
import com.bootcampzup.dream.services.PessoaService;

@RestController
@RequestMapping(value = "/api")
public class PessoaResource {
	@Autowired
	private PessoaService pessoaService;

	@GetMapping(path = "/pessoas")
	public ResponseEntity<List<Pessoa>> findAllPessoas() {
		List<Pessoa> list = pessoaService.findAllPessoas();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = "/pessoas/{id}")
	public ResponseEntity<Pessoa> findPessoaById(@PathVariable Long id) {
		Pessoa obj = pessoaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(path = "/pessoas")
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa obj) {

		LocalDate date = LocalDate.now();
		long difData = ChronoUnit.YEARS.between(date, obj.getdataNascimento());

		if (difData > -18) {
			System.out.println("Necessário ter no mínimo 18 anos");
			return ResponseEntity.badRequest().build();
		}

		obj = pessoaService.insert(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();

		return ResponseEntity.created(location).body(obj);
	}
}
