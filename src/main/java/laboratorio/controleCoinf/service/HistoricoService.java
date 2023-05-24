package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.HistoricoModel;
import laboratorio.controleCoinf.repository.HistoricoRepository;
import laboratorio.controleCoinf.rest.dto.HistoricoDto;
import laboratorio.controleCoinf.rest.form.HistoricoForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.HistoricoUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.DataIntegrityException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoService {
    @Autowired
    HistoricoRepository historicoRepository;

    @SneakyThrows
    public void delete(LocalDate id){
        try{
            if (historicoRepository.existsById(id)){
                historicoRepository.deleteById(id);
            }
        }catch (DataIntegrityViolationException H){
            throw new DataIntegrityException();
        }
    }
//------------------------------------------------------------------------------------

    private HistoricoModel convertHistoricoFormToHistoricoModel(HistoricoForm historicoForm){
        HistoricoModel historicoModel = new HistoricoModel();
        historicoModel.setDataHora(historicoForm.getDataHora());
        return historicoModel;
    }

    private HistoricoDto convertHistoricoModelToHistoricoDto(HistoricoModel historicoModel){
        HistoricoDto historicoDto = new HistoricoDto();
        historicoDto.setDataHoraHistDTO(historicoModel.getDataHora());
        return historicoDto;
    }

    private List<HistoricoDto> convertListToDto(List<HistoricoModel> list){
        List<HistoricoDto> historicoDtoList = new ArrayList<>();
        for (HistoricoModel historicoModel : list){
            HistoricoDto historicoDto = this.convertHistoricoModelToHistoricoDto(historicoModel);
            historicoDtoList.add(historicoDto);
        }
        return historicoDtoList;
    }
//-------------------Metodos criados para o HistoricoController------------------------------------------
    public List<HistoricoDto> findAll() {
        return null;
    }

    public HistoricoDto insert(HistoricoForm historicoForm) {
        return null;
    }

    public HistoricoDto update(HistoricoUpdateForm historicoUpdateForm, long id) {
        return null;
    }
}
