package com.example.demo.domain.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public record ResetSenhaRequest(
        @NotBlank(message = "Campo obrigatorio")
        String token,

         @NotBlank(message = "Campo obrigatorio")
         @Size(min = 5, message = "A senha deve ter no minimo 5 carateres")
         String novaSenha
) {


}
