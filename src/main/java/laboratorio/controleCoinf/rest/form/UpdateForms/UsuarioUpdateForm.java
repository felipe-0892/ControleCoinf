package laboratorio.controleCoinf.rest.form.UpdateForms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioUpdateForm {

    @NotNull(message = "O nome do usuário deve possuir até 64 caracteres")
    private String Nome;

    @NotNull(message = "A matricula deve possuir até 64 caracteres")
    private long Matricula;

    @NotBlank(message = "Senha não pode estar em branco!")
    @Size(max = 512, message = "A senha deve possuir até 512 caracteres.")
    private String Senha;

    @NotNull(message = "O campo ativo não pode ser nulo")
    private Boolean Ativo;

    @NotNull(message = "O campo ativo não pode ser nulo")
    private Boolean Admin;
}
