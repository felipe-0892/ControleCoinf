package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {

    List<DepartamentoModel> findByNomeDptContaining(String nomeDpt);

    Optional<DepartamentoModel> findByNomeDpt(String nomeDpt);

    @Query(value = "SELECT * FROM TB_DEPARTAMENTO d" + " WHERE d.NomeDpt = :NomeDpt", nativeQuery = true )
    Optional<DepartamentoModel> findAllByNomeDpt(@Param("NomeDpt") String nomeDpt);
}
