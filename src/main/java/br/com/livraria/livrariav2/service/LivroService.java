package br.com.livraria.livrariav2.service;

import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.model.entity.Editora;
import br.com.livraria.livrariav2.model.entity.Livro;
import br.com.livraria.livrariav2.model.dto.LivroDTO;
import br.com.livraria.livrariav2.repository.CategoriaRepository;
import br.com.livraria.livrariav2.repository.EditoraRepository;
import br.com.livraria.livrariav2.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    private final EditoraRepository editoraRepository;

    private final CategoriaRepository categoriaRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public List<Livro> findByNome(String nome){
        if (nome.isBlank()){
            return Collections.emptyList();
        }
        return livroRepository.findByNomeStartingWithIgnoreCase(nome);
    }
    public List<Livro> findByIsbn(String isbn){
        if (isbn.isBlank()){
            return Collections.emptyList();
        }
        return livroRepository.findByIsbnStartingWithIgnoreCase(isbn);
    }

    public List<Categoria> findByCategoria(String livrosPorCategoria){
        return categoriaRepository.findByNomeStartingWithIgnoreCase(livrosPorCategoria);
    }

    public List<Editora> findByEditora(String livrosPorEditora){
        return editoraRepository.findByNomeStartingWithIgnoreCase(livrosPorEditora);
    }

    public Livro findById(Long id){
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public Livro save(LivroDTO livroDTO){
        Livro livro = new Livro();
        Categoria categoria = new Categoria();
        Editora editora = new Editora();
        livro.setNome(livroDTO.getNome());
        livro.setCategoria(categoria);
        livro.setEditora(editora);
        return livroRepository.save(livro);
    }

    public Livro update(LivroDTO livroDTO, Long id){
        Livro livro = this.findById(id);
        livro.setNome(livroDTO.getNome());
        return livroRepository.save(livro);
    }

    public void delete(Long id){
        findById(id);
        livroRepository.deleteById(id);
    }

}
