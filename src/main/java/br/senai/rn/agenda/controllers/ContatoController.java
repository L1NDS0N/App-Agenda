package br.senai.rn.agenda.controllers;

import br.senai.rn.agenda.models.Contato;
import br.senai.rn.agenda.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService service;


	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Contato> contato = service.buscarTodos();
		if (contato.size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return  ResponseEntity.ok(contato);
	}

	@GetMapping("/editar/{id}")
	public ResponseEntity<Contato> editar(@PathVariable Long id){
		Optional<Contato> contato = Optional.of(service.buscar(id));
		if (contato.isPresent()){
			return ResponseEntity.ok((contato.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@RequestBody Contato contato, @PathVariable long id) {
		Optional<Contato> contatoOptional = Optional.of(service.buscar(id));
		if (contatoOptional.isPresent()){
			contato.setId(id);
			service.salvar(contato);

			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/remover/{id}")
	public String remover(@PathVariable Long id, Model model) {
		service.removerPorId(id);
		return "redirect:/";
	}

	@PostMapping
	public ResponseEntity<?> salva(@RequestBody Contato contato, UriComponentsBuilder uriBuilder){
		service.salvar(contato);

		URI uri = uriBuilder.path("/fabricantes/{id}")
				.buildAndExpand(contato.getId()).toUri();

		return ResponseEntity.created(uri).body(contato);
	}

}