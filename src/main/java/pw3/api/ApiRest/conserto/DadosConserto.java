package pw3.api.ApiRest.conserto;

import jakarta.validation.Valid;
import pw3.api.ApiRest.mecanico.DadosMecanico;
import pw3.api.ApiRest.veiculo.DadosVeiculo;

public record DadosConserto(String datadeentrada, String datadesaida,
                            @Valid
                            DadosVeiculo veiculo,
                            @Valid
                            DadosMecanico mecanico) {
}
