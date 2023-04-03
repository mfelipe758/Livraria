package br.com.livraria.livrariav2.repository;

import br.com.livraria.livrariav2.model.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    List<Editora> findByNomeStartingWithIgnoreCase(String nome);
}
