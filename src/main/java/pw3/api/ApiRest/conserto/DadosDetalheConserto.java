package pw3.api.ApiRest.conserto;

public record DadosDetalheConserto(long id, String datadeentrada, String datadesaida,
                                   String nome,
                                   String marca,
                                   String modelo) {
    public DadosDetalheConserto(Conserto conserto){
        this(conserto.getId(),conserto.getDatadeentrada(), conserto.getDatadesaida(),
                conserto.getMecanico().getNome(), conserto.getVeiculo().getMarca(), conserto.getVeiculo().getMarca());
    }
}
