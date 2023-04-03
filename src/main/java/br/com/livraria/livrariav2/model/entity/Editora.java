package br.com.livraria.livrariav2.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editoras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;
    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();
}
