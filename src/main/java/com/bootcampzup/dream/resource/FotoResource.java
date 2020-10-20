package com.bootcampzup.dream.resource;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcampzup.dream.model.FotoCpf;
import com.bootcampzup.dream.services.FotoCpfService;

@RestController
@RequestMapping(value = "/api")
public class FotoResource {

	@Autowired
	private FotoCpfService fotoCpfService;

	private static String dirname = "C:\\Users\\Guilherme\\eclipse-workspace\\dream\\uploads\\fotos\\";

	@GetMapping(path = "/pessoas/enderecos/fotos/{id}")
	public ResponseEntity<FotoCpf> findFotoById(@PathVariable Long id) {
		FotoCpf obj = fotoCpfService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/pessoas/enderecos/fotos")
	public ResponseEntity<FotoCpf> upload(FotoCpf obj, @RequestParam MultipartFile foto) {

		try {
			if (foto != null && !foto.isEmpty()) {
				byte[] bytes = foto.getBytes();
				Path dir = Paths.get(dirname + foto.getOriginalFilename());
				Files.write(dir, bytes);

				obj.setName(new Date().toString() + foto.getOriginalFilename());

				obj = fotoCpfService.insert(obj);
			} else {
				return ResponseEntity.badRequest().build();
			}

		} catch (IOException e) {
			e.getStackTrace();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFoto())
				.toUri();

		return ResponseEntity.created(location).body(obj);
	}

}
