package laboratorio.controleCoinf.rest.controller;


import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.UsuarioDto;
import laboratorio.controleCoinf.rest.form.UsuarioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.UsuarioUpdateForm;
import laboratorio.controleCoinf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<List<UsuarioDto>> findAll(){
        List<UsuarioDto> usuarioDtoList = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioDtoList);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> insert(@Valid @RequestBody UsuarioForm usuarioForm, BindingResult br) throws ConstraintException {
        if (br.hasErrors()) {
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        UsuarioDto usuarioDto = usuarioService.insert(usuarioForm);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@Valid @RequestBody UsuarioUpdateForm usuarioUpdateForm , @PathVariable("id") long id, BindingResult br) throws ConstraintException {
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        UsuarioDto usuarioDto = usuarioService.update(usuarioUpdateForm, id);
        return ResponseEntity.ok().body(usuarioDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }


// criado para tirar o erro do ConstraintException----------------------------------------------------------------------
    private class ConstraintException extends Throwable {
        public ConstraintException(String defaultMessage) {
        }
    }
}
