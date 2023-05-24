package laboratorio.controleCoinf.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HorarioDto {

    private Integer DataHoraInicioDTO;

    private Integer DataHoraFimDTO;

//--------------------------------Usos em HorarioService
    public void setDataHoraFimDTO(LocalDateTime dataHoraFim) {
    }

    public void setDataHoraInicioDTO(LocalDateTime dataHoraInicio) {
    }
}
