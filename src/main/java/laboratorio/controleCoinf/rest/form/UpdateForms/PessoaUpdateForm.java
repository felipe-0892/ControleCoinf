package laboratorio.controleCoinf.rest.form.UpdateForms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaUpdateForm {

    private Integer IDPessoa;

    @NotNull(message = "Pessoa deve possuir nome com até 64 caracteres ")
    private String nome;

    @NotNull(message = "CPF de pessoa deve possuir 11 caracteres")
    private String cpf;


    private LocalDate DataNascimento;

    private String sexo;
}
