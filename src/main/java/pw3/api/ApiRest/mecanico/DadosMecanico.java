package pw3.api.ApiRest.mecanico;

import jakarta.validation.constraints.NotNull;

public record DadosMecanico(
        @NotNull
        String nome,
        String anosxp) {
}
