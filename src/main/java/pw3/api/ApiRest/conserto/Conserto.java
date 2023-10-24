package pw3.api.ApiRest.conserto;

import pw3.api.ApiRest.mecanico.Mecanico;
import pw3.api.ApiRest.veiculo.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
    private String datadeentrada;

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
    private String datadesaida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;
    private Boolean ativo;


    public Conserto(DadosConserto dados) {
        this.ativo = true;
        this.id = dados.id();
        this.datadeentrada = dados.datadeentrada();
        this.datadesaida = dados.datadesaida();
        this.veiculo = new Veiculo(dados.veiculo());
        this.mecanico = new Mecanico(dados.mecanico());

    }
    public void excluir(){
        this.ativo = false;

    }
    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if(dados.datadesaida() != null) {
            this.datadesaida = dados.datadesaida();
        }
        if(dados.dadosMecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.dadosMecanico());
        }
    }
}



