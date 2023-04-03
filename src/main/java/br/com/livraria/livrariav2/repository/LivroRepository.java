package br.com.livraria.livrariav2.repository;

import br.com.livraria.livrariav2.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByNomeStartingWithIgnoreCase(String nome);
    List<Livro> findByIsbnStartingWithIgnoreCase(String isbn);
}
