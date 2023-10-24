package pw3.api.ApiRest.veiculo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

public record DadosVeiculo(
        @NotBlank
        @NotNull
        String marca,
        @NotBlank
        @NotNull
        String modelo,

        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String ano,
        String cor) {
}

