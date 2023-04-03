package br.com.livraria.livrariav2.service;

import br.com.livraria.livrariav2.model.entity.Editora;
import br.com.livraria.livrariav2.model.dto.EditoraDTO;
import br.com.livraria.livrariav2.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditoraService {
    private final EditoraRepository editoraRepository;

    public List<Editora> findAll(){
        return editoraRepository.findAll();
    }
    public List<Editora> findByNome(String nome){
        if (nome.isBlank()){
            return Collections.emptyList();
        }
        return editoraRepository.findByNomeStartingWithIgnoreCase(nome);
    }
    public Editora findById(Long id){
        return editoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public Editora save(EditoraDTO editoraDTO){
        Editora editora = new Editora();
        editora.setNome(editoraDTO.getNome());
        return editoraRepository.save(editora);
    }

    public Editora update(EditoraDTO editoraDTO, Long id){
        Editora editora = findById(id);
        editora.setNome(editoraDTO.getNome());
        return editoraRepository.save(editora);
    }

    public void delete(Long id){
        findById(id);
        editoraRepository.deleteById(id);
    }
}
