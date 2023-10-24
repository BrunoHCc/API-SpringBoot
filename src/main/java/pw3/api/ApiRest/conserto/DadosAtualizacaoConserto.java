package pw3.api.ApiRest.conserto;

import pw3.api.ApiRest.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        String datadesaida,
        DadosMecanico mecanico) { }
