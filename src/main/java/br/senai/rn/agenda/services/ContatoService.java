package br.senai.rn.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.rn.agenda.models.Contato;
import br.senai.rn.agenda.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;

	public void salvar(Contato contato) {
		repository.save(contato);
	}

	public List<Contato> buscarTodos() {
		return repository.findAll();
	}

	public Contato buscar(Long id) {
		return repository.findById(id).get();
	}

	public void remover(Contato contato) {
		repository.delete(contato);
	}

	public void removerPorId(Long id) {
		repository.deleteById(id);
	}
	
}
