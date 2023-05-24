package laboratorio.controleCoinf.service;

import laboratorio.controleCoinf.model.UsuarioModel;
import laboratorio.controleCoinf.repository.UsuarioRepository;
import laboratorio.controleCoinf.rest.dto.UsuarioDto;
import laboratorio.controleCoinf.rest.form.UsuarioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.UsuarioUpdateForm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @SneakyThrows
    public void delete(long id){
        try{
            if (usuarioRepository.existsById(id)){

                usuarioRepository.deleteById(id);
            }
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException();
        }
    }
//--------------------------------------------------------------------------------------------------------------------

    private UsuarioModel convertUsuarioFormToUsuarioModel(UsuarioForm usuarioForm){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioForm.getNome());
        usuarioModel.setMatricula(usuarioForm.getMatricula());
        usuarioModel.setSenha(usuarioForm.getSenha());
        usuarioModel.setAdmin(usuarioForm.getAdmin());
        usuarioModel.setAtivo(usuarioForm.getAtivo());
        return usuarioModel;
    }

    private UsuarioDto convertUsuarioModelToUsuarioDto(UsuarioModel usuarioModel){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome(usuarioModel.getNome());
        usuarioDto.setMatricula(usuarioModel.getMatricula());
        usuarioDto.setSenha(usuarioModel.getSenha());
        usuarioDto.setAtivo(usuarioModel.getAtivo());
        usuarioDto.setAdmin(usuarioModel.getAdmin());
        return usuarioDto;
    }

    private List<UsuarioDto> convertListToDto(List<UsuarioModel> list){
        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for (UsuarioModel usuarioModel : list){
            UsuarioDto usuarioDto = this.convertUsuarioModelToUsuarioDto(usuarioModel);
            usuarioDtoList.add(usuarioDto);
        }
        return usuarioDtoList;
    }
//---------------------------------------------------- Metodos criados para o  UsuarioController ----------------------------------
    public List<UsuarioDto> findAll() {

        return null;
    }

    public UsuarioDto insert(UsuarioForm usuarioForm) {

        return null;
    }

    public UsuarioDto update(UsuarioUpdateForm usuarioUpdateForm, long id) {

        return null;
    }



// criado para o erro do DataIntegrityException-------------------------------------------------------------------------
    private static class DataIntegrityException extends Throwable {
        public DataIntegrityException() {
        }
    }
}
