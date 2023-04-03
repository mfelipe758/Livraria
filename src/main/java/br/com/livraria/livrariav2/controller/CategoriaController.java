package br.com.livraria.livrariav2.controller;

import br.com.livraria.livrariav2.model.dto.CategoriaDTO;
import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos(){
        return ResponseEntity.ok(categoriaService.findAll());
    }
    @GetMapping("/listarPorNome")
    public ResponseEntity<List<Categoria>> listarNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(categoriaService.findByNome(nome));
    }
    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Categoria> listarId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }
    @PostMapping("/criar")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody CategoriaDTO categoriaDTO){
        return new ResponseEntity<>(categoriaService.save(categoriaDTO),HttpStatus.CREATED);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Categoria> editar(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id){
        return new ResponseEntity<>(categoriaService.update(categoriaDTO, id), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
