package laboratorio.controleCoinf.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Column(nullable = false, name = "NomePessoa", length = 128, unique = true)
    private String nomePessoa;

    @Column(nullable = false, name = "CPF", length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, name = "DataNascimento", unique = true)
    private LocalDate dataNasc;

    @Column(nullable = false, name = "Sexo", length = 64, unique = true)
    private String sexo;

//--------------------------------------- criando a partir do ALT + Enter----------------------------------------------
    public void getDataNascimento(LocalDate dataNascimento) {
    }

    public void setDataNascimento(LocalDate dataNascimento) {
    }

}
