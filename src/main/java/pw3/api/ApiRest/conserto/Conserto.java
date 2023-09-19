package pw3.api.ApiRest.conserto;

import pw3.api.ApiRest.mecanico.Mecanico;
import pw3.api.ApiRest.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datadeentrada;
    private String datadesaida;
    @Embedded
    private Veiculo veiculo;
    @Embedded
    private Mecanico mecanico;

    public Conserto(DadosConserto dados) {
        this.datadeentrada = dados.datadeentrada();
        this.datadesaida = dados.datadesaida();
        this.veiculo = new Veiculo(dados.veiculo());
        this.mecanico = new Mecanico(dados.mecanico());

    }
}
