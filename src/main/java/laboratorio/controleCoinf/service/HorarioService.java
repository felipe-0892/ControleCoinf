package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.HorarioModel;
import laboratorio.controleCoinf.repository.HorarioRepository;
import laboratorio.controleCoinf.rest.dto.HorarioDto;
import laboratorio.controleCoinf.rest.dto.PessoaDto;
import laboratorio.controleCoinf.rest.form.HorarioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.HorarioUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.DataIntegrityException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    HorarioRepository horarioRepository;

    @SneakyThrows
    public void delete(long id){
        try{
            if (horarioRepository.existsById(id)){
                horarioRepository.deleteById(id);
            }
        }catch (DataIntegrityViolationException h){
            throw new DataIntegrityException();
        }
    }
//---------------------------------------------------------------------------------
    private HorarioModel convertHorarioFormToHorarioModel(HorarioForm horarioForm){
        HorarioModel horarioModel = new HorarioModel();
        horarioModel.setDataHoraInicio(horarioForm.getDataHoraInicio);
        horarioModel.setDataHoraFim(horarioForm.getDataHoraFim);
        return horarioModel;
    }

    private HorarioDto convetHorarioModelToHorarioDto(HorarioModel horarioModel){
        HorarioDto horarioDto = new HorarioDto();
        horarioDto.setDataHoraInicioDTO(horarioModel.getDataHoraInicio());
        horarioDto.setDataHoraFimDTO(horarioModel.getDataHoraFim());
        return horarioDto;
    }

    private List<HorarioDto> convertListToDto(List<HorarioModel> list){
        List<HorarioDto> horarioDtoList = new ArrayList<>();

        for (HorarioModel horarioModel: list){
            HorarioDto horarioDto = this.convetHorarioModelToHorarioDto(horarioModel);
            horarioDtoList.add(horarioDto);
        }
        return horarioDtoList;
    }
//--------------------------------------- Metodos criados para HorarioController--------------------------
    public List<PessoaDto> findAll() {
        return null;
    }

    public HorarioDto insert(HorarioForm horarioForm) {
        return null;
    }


    public HorarioDto update(HorarioUpdateForm horarioUpdateForm, long id) {
        return null;
    }
}
