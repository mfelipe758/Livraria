package br.com.livraria.livrariav2.model.entity;

import br.com.livraria.livrariav2.model.entity.Categoria;
import br.com.livraria.livrariav2.model.entity.Editora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String isbn;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

}
