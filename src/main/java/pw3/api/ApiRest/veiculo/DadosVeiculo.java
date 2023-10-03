package pw3.api.ApiRest.veiculo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotNull
        String marca,
        @NotNull
        String modelo,
        @Pattern(regexp = "\\d{4}")
        String ano,
        String cor) {
}

