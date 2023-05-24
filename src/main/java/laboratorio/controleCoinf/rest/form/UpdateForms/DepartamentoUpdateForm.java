package laboratorio.controleCoinf.rest.form.UpdateForms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartamentoUpdateForm {

    @NotNull(message = "Nome do departamento deve conter no máximo 128 caracteres")
    private String nomeDPT;


    @NotNull(message = "descrição devete conter até 256 caracteres")
    private String descricaDPT;
}
