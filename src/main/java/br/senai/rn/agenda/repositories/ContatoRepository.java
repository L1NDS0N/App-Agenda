package br.senai.rn.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.rn.agenda.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {}
