package br.com.livraria.livrariav2.repository;

import br.com.livraria.livrariav2.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNomeStartingWithIgnoreCase(String nome);
}
