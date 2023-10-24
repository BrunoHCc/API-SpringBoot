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
        @Pattern(regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")
        String datadeentrada,

        @NotBlank
        @Pattern(regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")
        String datadesaida,

        @NotNull
        @Valid
        DadosVeiculo veiculo,

        @NotNull
        @Valid
        DadosMecanico mecanico) {
}
