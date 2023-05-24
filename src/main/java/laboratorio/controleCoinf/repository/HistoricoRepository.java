package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.HistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HistoricoRepository extends JpaRepository<HistoricoModel, LocalDate> {

    List<HistoricoModel> findByDataHoraContaining(LocalDate dataHora);

     Optional<HistoricoModel> findByDataHora(LocalDate dataHora);

     @Query(value = "SELECT * FROM TB_HISTORICO h" + " WHERE h.dataHora = :dataHora", nativeQuery = true)
     List<HistoricoModel> findAllByDataHora(@Param("dataHora") LocalDate dataHora);


}
