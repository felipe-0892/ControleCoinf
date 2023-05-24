package laboratorio.controleCoinf.repository;

import laboratorio.controleCoinf.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    List<PessoaModel> findByNomePessoaContaining(String nomePessoa);

    Optional<PessoaModel> findByCpf(String cpf);

    @Query(value = "SELECT * FROM TB_PESSOA p" + " WHERE p.nomePessoa = :nomePessoa", nativeQuery = true)
    List<PessoaModel> findByAllNomePessoa(@Param("nomePessoa") String nomePessoa);

    @Query(value = "SELECT * FROM TB_PESSOA p" + " WHERE p.cpf = :cpf", nativeQuery = true)
    List<PessoaModel>findByAllCpf(@Param("cpf")String cpf);

    @Query(value = "SELECT * FROM TB_PESSOA p" + " WHERE p.dataNasc = :dataNasc", nativeQuery = true)
    List<PessoaModel>findByAllDataNasc(@Param("dataNasc") LocalDate dataNasc);



    //criado para existsbyId no PessoaService
    public static boolean existsById() {
        return false;
    }

    default void deleteById() {
        deleteById();
    }


}
