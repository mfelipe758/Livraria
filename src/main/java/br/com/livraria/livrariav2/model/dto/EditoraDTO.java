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
public class EditoraDTO {
    @Size(max = 255, message = "Você ultrapassou o limite de {max} caracteres!")
    @NotBlank(message = "Nome obrigatorio!")
    private String nome;

    private String descricao;
}
