package laboratorio.controleCoinf.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDto {
    private String Nome;
    private String Matricula;
    private String Senha;
    private Boolean Ativo;
    private Boolean Admin;
}
