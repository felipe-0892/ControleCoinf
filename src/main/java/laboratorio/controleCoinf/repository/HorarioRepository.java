package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.HorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HorarioRepository extends JpaRepository<HorarioModel, Long> {

    List<HorarioModel>findByDataHoraInicioContaining(LocalDateTime dataHoraInicio);

    List<HorarioModel>findByOrderByDataHoraInicio();

    @Query(value = "SELECT * FROM TB_HORARIO h" + " WHERE h.horaInicio = :DataHoraInicio", nativeQuery = true)
    List<HorarioModel> findAllByDataHoraInicio(@Param("DataHoraInicio") LocalDateTime DataHoraInicio);

    @Query(value = "SELECT * FROM TB_HORARIO h" + " WHERE h.horafim = :DataHoraFim", nativeQuery = true)
    List<HorarioModel>findAllByDataHoraFim(@Param("DataHoraFim") LocalDateTime DataHoraFim);


}
