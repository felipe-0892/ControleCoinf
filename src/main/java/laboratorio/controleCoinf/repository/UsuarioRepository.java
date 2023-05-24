package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    List<UsuarioModel> findByNomeContaining(String nome);

    List<UsuarioModel>findByOrderByNomeDesc();

    @Query(value = "SELECT * FROM TB_USUARIO u" + " WHERE u.nome = :NomeUser", nativeQuery = true)
    List<UsuarioModel>findByAllEmail(@Param("NomeUser") String nomeUser);

    @Query(value = "SELECT * FROM TB_USUARIO u" + " WHERE u.matricula = : matricula", nativeQuery = true)
    List<UsuarioModel>findByAllMatricula(@Param("Matricula") String matricula);

    List<Object> findByMatricula(String matricula);


}
