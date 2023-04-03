package br.com.livraria.livrariav2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorMessage {
    private Long timestamp;
    private int status;
    private String error;
    private List<FieldMessage> messages;
}
