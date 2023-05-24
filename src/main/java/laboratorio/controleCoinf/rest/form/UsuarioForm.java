package laboratorio.controleCoinf.rest.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioForm {
    @NotNull
    private Integer IDUsuario;

    @NotNull(message = "O nome do usuário deve possuir até 64 caracteres")
    private String nome;

    @NotNull(message = "A matricula deve possuir até 64 caracteres")
    private long matricula;

    @NotBlank(message = "Campo da senha não está preenchido!")
    @Size(max = 512, message = "A senha deve possuir até 512 caracteres.")
    private String senha;

    @NotNull(message = "O campo ativo não pode ser nulo")
    private Boolean ativo;

    @NotNull(message = "O campo ativo não pode ser nulo")
    private Boolean admin;


}
