package pw3.api.ApiRest.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AlgunsDadosConserto(
        @NotBlank
        Long id,
        @NotBlank
        @Pattern(regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")
        String entrada,
        @NotBlank
        @Pattern(regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")
        String saida,
        @NotBlank
        String nome,
        @NotBlank
        String marca,
        @NotBlank
        String modelo
) {
    public AlgunsDadosConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getDatadeentrada(), conserto.getDatadesaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
