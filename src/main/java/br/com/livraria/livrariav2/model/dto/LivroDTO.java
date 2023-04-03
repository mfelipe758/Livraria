package br.com.livraria.livrariav2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    private Long id;
    @NotBlank(message = "Nome obrigatorio!")
    private String nome;
//    @Size(max = 13, message = "Você ultrapassou o limite de {max} caracteres!")
    private String isbn;
//    @Size(message = "Informe uma categoria!")
    private Long categoriaID;
//    @Size(message = "Informe uma editora!")

    private Long editoraID;
}
