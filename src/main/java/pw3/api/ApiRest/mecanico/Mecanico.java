package pw3.api.ApiRest.mecanico;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    @NotBlank
    private String nome;
    private String anosxp;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosxp = dados.anosxp();
    }
    public void atualizarInformacoes(DadosMecanico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.anosxp() != null) {
            this.anosxp = dados.anosxp();

        }
    }
}