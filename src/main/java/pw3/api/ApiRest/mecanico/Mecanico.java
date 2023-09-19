package pw3.api.ApiRest.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String anosxp;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosxp = dados.anosxp();
    }
}