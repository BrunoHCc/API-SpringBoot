package pw3.api.ApiRest.conserto;

import pw3.api.ApiRest.mecanico.DadosMecanico;
import pw3.api.ApiRest.veiculo.DadosVeiculo;

public record DadosConserto(String datadeentrada, String datadesaida,
                            DadosVeiculo veiculo,
                            DadosMecanico mecanico) {
}