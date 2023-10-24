package pw3.api.ApiRest.conserto;

import jakarta.validation.constraints.Pattern;
import pw3.api.ApiRest.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        @Pattern(regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")
        String datadesaida,
        DadosMecanico dadosMecanico) { }
