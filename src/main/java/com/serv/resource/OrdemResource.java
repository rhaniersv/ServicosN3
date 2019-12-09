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

import com.serv.model.Ordem;
import com.serv.repository.OrdemRepository;



@RestController
@RequestMapping("/ordem")
public class OrdemResource {

	@Autowired
	private OrdemRepository ordemRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	
	@GetMapping
	public List<Ordem> readList(){
		return ordemRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Ordem> findById(@PathVariable int id){
		return ordemRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Ordem> create(@RequestBody Ordem ordem, HttpServletResponse response){
		Ordem save = ordemRepository.save(ordem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		ordemRepository.deleteById(id);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Ordem> update(@PathVariable int id, @RequestBody Ordem ordem){
		Optional<Ordem> ordemBanco = ordemRepository.findById(id);
		BeanUtils.copyProperties(ordem, ordemBanco.get(),"id");
		ordemRepository.save(ordemBanco.get());
		return ResponseEntity.ok(ordem);
	}
}
