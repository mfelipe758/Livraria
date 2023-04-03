package br.com.livraria.livrariav2.service;

import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.model.dto.CategoriaDTO;
import br.com.livraria.livrariav2.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public List<Categoria> findByNome(String nome){
        if (nome.isBlank()){
            return Collections.emptyList();
        }
        return categoriaRepository.findByNomeStartingWithIgnoreCase(nome);
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public Categoria save(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        return categoriaRepository.save(categoria);
    }

    public Categoria update(CategoriaDTO categoriaDTO, Long id){
        Categoria categoria = this.findById(id);
        categoria.setNome(categoriaDTO.getNome());
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id){
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
