package laboratorio.controleCoinf.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_DEPARTAAMENTO")

public class DepartamentoModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;

    @Column(nullable = false, name = "NomeDPT", length = 128, unique = true)
    private String nomeDpt; //Nome Departamento

    @Column(nullable = false, name = "DescricaoDPT", length = 256, unique = true)
    private String descricaoDpt;
}
