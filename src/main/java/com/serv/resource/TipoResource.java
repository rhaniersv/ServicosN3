package com.serv.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serv.model.Tipo;
import com.serv.repository.TipoRepository;

@RestController
@RequestMapping("/tipo")
public class TipoResource {

	
	@Autowired
	private TipoRepository tipoRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	
	@GetMapping
	public List<Tipo> readList(){
		return tipoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Tipo> findById(@PathVariable int id){
		return tipoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Tipo> create(@RequestBody Tipo tipo, HttpServletResponse response){
		Tipo save = tipoRepository.save(tipo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		tipoRepository.deleteById(id);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Tipo> update(@PathVariable int id, @RequestBody Tipo tipo){
		Optional<Tipo> tipoBanco = tipoRepository.findById(id);
		BeanUtils.copyProperties(tipo, tipoBanco.get(),"id");
		tipoRepository.save(tipoBanco.get());
		return ResponseEntity.ok(tipo);
	}
}
