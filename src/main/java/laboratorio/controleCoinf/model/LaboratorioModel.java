package laboratorio.controleCoinf.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_LABORATORIO")
public class LaboratorioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLaboratorio;

    @Column(nullable = false, name = "NomeLab", length = 64, unique = true)
    private String nomeLab;

    @Column(nullable = false, name = "DescricaoLab", length = 256, unique = true)
    private String descricaoLab;
}
