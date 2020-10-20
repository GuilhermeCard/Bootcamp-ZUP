package com.bootcampzup.dream.resource;

import java.net.URI;
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

import com.bootcampzup.dream.model.Endereco;
import com.bootcampzup.dream.services.EnderecoService;

@RestController
@RequestMapping(value = "/api")
public class EnderecoResource {
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(path = "/pessoas/enderecos")
	public ResponseEntity<List<Endereco>> findAllEnderecos() {
		List<Endereco> list = enderecoService.findAllEnderecos();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = "/pessoas/enderecos/{id}")
	public ResponseEntity<Endereco> findEnderecoById(@PathVariable Long id) {
		Endereco obj = enderecoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(path = "/pessoas/enderecos")
	public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco obj) {

		obj = enderecoService.insert(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdEndereco()).toUri();
		return ResponseEntity.created(location).body(obj);
	}

}
