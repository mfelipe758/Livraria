package br.com.livraria.livrariav2.controller;

import br.com.livraria.livrariav2.model.dto.EditoraDTO;
import br.com.livraria.livrariav2.model.dto.LivroDTO;
import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.model.entity.Editora;
import br.com.livraria.livrariav2.model.entity.Livro;
import br.com.livraria.livrariav2.service.EditoraService;
import br.com.livraria.livrariav2.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos(){
        return ResponseEntity.ok(livroService.findAll());
    }
    @GetMapping("/listarPorNome")
    public ResponseEntity<List<Livro>> listarNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(livroService.findByNome(nome));
    }
    @GetMapping("/listarPorIsbn")
    public ResponseEntity<List<Livro>> listarIsbn(@RequestParam("isbn") String isbn){
        return ResponseEntity.ok(livroService.findByIsbn(isbn));
    }
    @GetMapping("/listarPorCategoria")
    public ResponseEntity<List<Categoria>> listarCategoria(@RequestParam("categoria") String categoria){
        return ResponseEntity.ok(livroService.findByCategoria(categoria));
    }
    @GetMapping("/listarPorEditora")
    public ResponseEntity<List<Editora>> listarEditora(@RequestParam("editora") String editora){
        return ResponseEntity.ok(livroService.findByEditora(editora));
    }
    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Livro> listarId(@PathVariable Long id){
        return ResponseEntity.ok(livroService.findById(id));
    }
    @PostMapping("/criar")
    public ResponseEntity<Livro> criar(@Valid @RequestBody LivroDTO livroDTO){
        return new ResponseEntity<>(livroService.save(livroDTO), HttpStatus.CREATED);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Livro> editar(@Valid @RequestBody LivroDTO livroDTO, @PathVariable Long id){
        return new ResponseEntity<>(livroService.update(livroDTO, id), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
