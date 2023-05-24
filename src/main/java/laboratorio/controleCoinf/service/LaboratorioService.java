package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.LaboratorioModel;
import laboratorio.controleCoinf.repository.LaboratorioRepository;
import laboratorio.controleCoinf.rest.dto.LaboratorioDto;
import laboratorio.controleCoinf.rest.form.LaboratorioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.LaboratorioUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.DataIntegrityException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratorioService {
    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @SneakyThrows
    public void delete(String id){
        try{
            if (laboratorioRepository.existsById(id)){
                laboratorioRepository.deleteById(id);
            }
        }catch (DataIntegrityViolationException l){
            throw new DataIntegrityException();
        }
    }

//----------------------------------------------------------------------------------------------------

    private LaboratorioModel convertLaboratorioFormToLaboratorioModel(LaboratorioForm laboratorioForm){
        LaboratorioModel laboratorioModel = new LaboratorioModel();
        laboratorioModel.setNomeLab(laboratorioForm.getNomeLab());
        laboratorioModel.setDescricaoLab(laboratorioForm.getDescricao());
        return laboratorioModel;
    }

    private LaboratorioDto convertLaboratorioModelToUsuarioDto(LaboratorioModel laboratorioModel){
        LaboratorioDto laboratorioDto = new LaboratorioDto();
        laboratorioDto.setNomeLabDTO(laboratorioModel.getNomeLab());
        laboratorioDto.setDescricaoLabDTO(laboratorioModel.getDescricaoLab());
        return laboratorioDto;
    }

    private List<LaboratorioDto> convertListToDto(List<LaboratorioModel> list){
        List<LaboratorioDto> laboratorioDtoList = new ArrayList<>();
        for (LaboratorioModel laboratorioModel : list){
            LaboratorioDto laboratorioDto = this.convertLaboratorioModelToUsuarioDto(laboratorioModel);
            laboratorioDtoList.add(laboratorioDto);
        }
        return laboratorioDtoList;
    }
//-----------------Metodos criados para LaboratorioController---------------------------------------------

    public List<LaboratorioDto> findAll() {
        return null;
    }

    public LaboratorioDto insert(LaboratorioForm laboratorioForm) {
        return null;
    }

    public LaboratorioDto update(LaboratorioUpdateForm laboratorioUpdateForm, long id) {
        return null;
    }
}
