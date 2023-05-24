package laboratorio.controleCoinf.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_HISTORICO")
public class HistoricoModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;

    @Column(nullable = false, name = "DataHora", unique = true)
    private LocalDate dataHora;

}
