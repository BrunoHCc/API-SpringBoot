package pw3.api.ApiRest.conserto;

import pw3.api.ApiRest.mecanico.Mecanico;
import pw3.api.ApiRest.veiculo.Veiculo;

public record DadosListagemConserto(long id,String datadeentrada, String datadesaida,
                                    String nome,
                                    String marca,
                                    String modelo) {
    public DadosListagemConserto(Conserto conserto){
        this(conserto.getId(),conserto.getDatadeentrada(), conserto.getDatadesaida(),
                conserto.getMecanico().getNome(), conserto.getVeiculo().getMarca(), conserto.getVeiculo().getMarca());
    }
}
