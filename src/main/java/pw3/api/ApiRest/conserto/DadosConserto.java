package pw3.api.ApiRest.conserto;

import jakarta.validation.Valid;
import pw3.api.ApiRest.mecanico.DadosMecanico;
import pw3.api.ApiRest.veiculo.DadosVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosConserto(

        long id,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String datadeentrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String datadesaida,

        @NotNull
        @Valid
        DadosVeiculo veiculo,

        @NotNull
        @Valid
        DadosMecanico mecanico) {
}
