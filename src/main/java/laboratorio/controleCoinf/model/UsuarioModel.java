package laboratorio.controleCoinf.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIOS")

public class UsuarioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, name = "Nome", length = 64, unique = true)
    private String nome;

    @Column(nullable = false, name = "Matricula", length = 64, unique = true)
    private String matricula;

    @Column(nullable = false, name ="Senha", length = 512, unique = true)
    private String senha;

    @Column(nullable = false, name = "Ativo", length = 2, unique = true)
    private Boolean ativo;

    @Column(nullable = false, name = "Admin", length = 2, unique = true)
    private Boolean admin;


// criado para setMatricula em UsuarioService  no private---------------------------------------------------------------
    public void setMatricula(long matricula) {
    }
}
