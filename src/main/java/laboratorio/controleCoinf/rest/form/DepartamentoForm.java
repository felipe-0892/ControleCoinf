package laboratorio.controleCoinf.rest.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartamentoForm {

    private Integer IdDepartamento;

    @NotNull(message = "Nome do departamento deve conter no máximo 128 caracteres")
    private String nomeDPT;


    @NotNull(message = "descrição devete conter até 256 caracteres")
    private String descricaDPT;
}
