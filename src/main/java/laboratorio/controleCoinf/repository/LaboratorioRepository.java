package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.HistoricoModel;
import laboratorio.controleCoinf.model.LaboratorioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LaboratorioRepository extends JpaRepository<LaboratorioModel, String> {

    List<LaboratorioModel> findByNomeLabContaining(String nomeLab);


    Optional<LaboratorioModel> findByNomeLab(String nomeLab);

    @Query(value = "SELECT * FROM TB_LABORATORIO l" + " WHERE l.nomelab = :nomeLab", nativeQuery = true)
    List<HistoricoModel> findByAllNomeLab(@Param("nomeLab") String nomeLab);


}
