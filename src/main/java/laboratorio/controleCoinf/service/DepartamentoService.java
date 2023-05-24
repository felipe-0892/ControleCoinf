package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.DepartamentoModel;
import laboratorio.controleCoinf.repository.DepartamentoRepository;
import laboratorio.controleCoinf.rest.dto.DepartamentoDto;
import laboratorio.controleCoinf.rest.form.DepartamentoForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.DepartamentoUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.DataIntegrityException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;


    @SneakyThrows
    public void delete(long id){
        try{
            if (departamentoRepository.existsById(id)){
                departamentoRepository.deleteById(id);
            }
        }catch (DataIntegrityViolationException d){
            throw new DataIntegrityException();
        }
    }
//------------------------------------------------------------------------------------------------------------

    private DepartamentoModel convertDepartamentoFormToDepartamentoModel(DepartamentoForm departamentoForm){
        DepartamentoModel departamentoModel = new DepartamentoModel();
        departamentoModel.setNomeDpt(departamentoForm.getNomeDPT());
        departamentoModel.setDescricaoDpt(departamentoForm.getDescricaDPT());
        return departamentoModel;
    }

    private DepartamentoDto convertDepartamenntoModelToDepartamentoDto(DepartamentoModel departamentoModel){
        DepartamentoDto departamentoDto = new DepartamentoDto();
        departamentoDto.setNomeDTO(departamentoModel.getNomeDpt());
        departamentoDto.setDescDptDTP(departamentoModel.getDescricaoDpt());
        return departamentoDto;
    }

    private List<DepartamentoDto> convertListToDto(List<DepartamentoModel> list){
        List<DepartamentoDto> departamentoDtoList = new ArrayList<>();
        for (DepartamentoModel departamentoModel : list){
            DepartamentoDto departamentoDto = this.convertDepartamenntoModelToDepartamentoDto(departamentoModel);
            departamentoDtoList.add(departamentoDto);
        }
        return departamentoDtoList;
    }
//--------------------------------Metodos criados para o DepartamentoController-----------------------------------

    public List<DepartamentoDto> findAll() {
        return null;
    }


    public DepartamentoDto insert(DepartamentoForm departamentoForm) {
        return null;
    }

    public DepartamentoDto update(DepartamentoUpdateForm departamentoUpdateForm, long id) {
        return null;
    }
}
