package br.com.livraria.livrariav2.controller;

import br.com.livraria.livrariav2.model.dto.CategoriaDTO;
import br.com.livraria.livrariav2.model.dto.EditoraDTO;
import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.model.entity.Editora;
import br.com.livraria.livrariav2.service.CategoriaService;
import br.com.livraria.livrariav2.service.EditoraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editoras")
@RequiredArgsConstructor
public class EditoraController {
    private final EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> listarTodos(){
        return ResponseEntity.ok(editoraService.findAll());
    }
    @GetMapping("/listarPorNome")
    public ResponseEntity<List<Editora>> listarNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(editoraService.findByNome(nome));
    }
    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Editora> listarId(@PathVariable Long id){
        return ResponseEntity.ok(editoraService.findById(id));
    }
    @PostMapping("/criar")
    public ResponseEntity<Editora> criar(@Valid @RequestBody EditoraDTO editoraDTO){
        return new ResponseEntity<>(editoraService.save(editoraDTO), HttpStatus.CREATED);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Editora> editar(@Valid @RequestBody EditoraDTO editoraDTO, @PathVariable Long id){
        return new ResponseEntity<>(editoraService.update(editoraDTO, id), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
