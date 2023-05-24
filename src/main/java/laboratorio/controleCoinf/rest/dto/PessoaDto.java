package laboratorio.controleCoinf.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaDto {

    private String nomePessoa;

    private String CPF;

    private LocalDate DataNasc;

    private String Sexo;

    public void setDataNasc(LocalDate dataNasc) {
    }


}
