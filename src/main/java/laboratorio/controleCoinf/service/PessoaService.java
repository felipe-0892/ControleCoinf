package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.PessoaModel;
import laboratorio.controleCoinf.repository.PessoaRepository;
import laboratorio.controleCoinf.rest.dto.PessoaDto;
import laboratorio.controleCoinf.rest.form.PessoaForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.PessoaUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.DataIntegrityException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;


    @SneakyThrows
    public void delete (){
        try{
            if (PessoaRepository.existsById()){
                pessoaRepository.deleteById();
            }
        }catch (DataIntegrityViolationException p){
            throw new DataIntegrityException();
        }
    }
//------------------------------------------------------------------------------------------------------------------
    private PessoaModel convertPessoaFormToPessoaModel(PessoaForm pessoaForm){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNomePessoa(pessoaForm.getNome());
        pessoaModel.setCpf(pessoaForm.getCpf());
        pessoaModel.setDataNascimento(pessoaForm.getDataNascimento());
        pessoaModel.setSexo(pessoaForm.getSexo());

        return pessoaModel;
    }

    private PessoaDto convertPessoaModelToPessoaDto(PessoaModel pessoaModel){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setNomePessoa(pessoaModel.getNomePessoa());
        pessoaDto.setCPF(pessoaModel.getCpf());
        pessoaDto.setDataNasc(pessoaModel.getDataNasc());
        pessoaDto.setSexo(pessoaModel.getSexo());

        return pessoaDto;
    }

    private List<PessoaDto> convertListToDto(List<PessoaModel> list){
        List<PessoaDto> pessoaDtoList = new ArrayList<>();
        for (PessoaModel pessoaModel: list){
            PessoaDto pessoaDto = this.convertPessoaModelToPessoaDto(pessoaModel);
            pessoaDtoList.add(pessoaDto);
        }
        return pessoaDtoList;
    }
//---------------------------------Metodos criados para pessoa controller--------------
    public List<PessoaDto> findAll() {
        return null;
    }

    public PessoaDto insert(PessoaForm pessoaForm) {
        return null;
    }

    public PessoaDto update(PessoaUpdateForm pessoaUpdateForm, String id) {
        return null;
    }

    public Object delete(String id) {
        return null;
    }
}
