package laboratorio.controleCoinf.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_HORARIO")
public class HorarioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @Column(nullable = false, name = "DataHoraInicio", unique = true)
    private LocalDateTime dataHoraInicio;

    @Column(nullable = false, name = "DataHOraFim", unique = true)
    private LocalDateTime dataHoraFim;


//--------------------------------------------------------- Usos em HorarioService

    public void setDataHoraInicio(Integer getDataHoraInicio) {
    }

    public void setDataHoraFim(Integer getDataHoraFim) {
    }
}
