package laboratorio.controleCoinf.rest.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LaboratorioForm {


    private Integer IDLaboratorio;


    @NotNull(message = "O nome do Laboratório deve possuir até 64 caracteres")
    private String nomeLab;


    @NotNull(message ="A descrição deve possuir até 256 caracteres")
    private String descricao;
}
