package laboratorio.controleCoinf.rest.form.UpdateForms;

import jakarta.validation.constraints.NotNull;

public class LaboratorioUpdateForm {

    private Integer IDLaboratorio;


    @NotNull(message = "O nome do Laboratório deve possuir até 64 caracteres")
    private String nomeLab;


    @NotNull(message ="A descrição deve possuir até 256 caracteres")
    private String descricao;
}
