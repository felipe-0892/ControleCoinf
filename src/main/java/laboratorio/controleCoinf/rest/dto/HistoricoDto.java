package laboratorio.controleCoinf.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistoricoDto {
    private LocalDate DataHoraHistDTO;
}
