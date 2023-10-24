package pw3.api.ApiRest.mecanico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotNull
        @NotBlank
        String nome,
        String anosxp) {
}
