package laboratorio.controleCoinf.rest.controller;


import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.HorarioDto;
import laboratorio.controleCoinf.rest.dto.PessoaDto;
import laboratorio.controleCoinf.rest.form.HorarioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.HorarioUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.ConstraintException;
import laboratorio.controleCoinf.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @GetMapping("/{id}")
    public ResponseEntity<List<PessoaDto>> findAll(){
        List<PessoaDto> pessoaDtoList = horarioService.findAll();
        return ResponseEntity.ok().body(pessoaDtoList);
    }

    @PostMapping
    public ResponseEntity<HorarioDto> insert(@Valid @RequestBody HorarioForm horarioForm, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }

        HorarioDto horarioDto = horarioService.insert(horarioForm);
        return ResponseEntity.ok().body(horarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioDto> update(@Valid @RequestBody HorarioUpdateForm horarioUpdateForm, @PathVariable("id") long id, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        HorarioDto horarioDto = horarioService.update(horarioUpdateForm, id);
        return ResponseEntity.ok().body(horarioDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        horarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
