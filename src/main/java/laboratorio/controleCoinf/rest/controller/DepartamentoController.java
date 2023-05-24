package laboratorio.controleCoinf.rest.controller;

import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.DepartamentoDto;
import laboratorio.controleCoinf.rest.form.DepartamentoForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.DepartamentoUpdateForm;
import laboratorio.controleCoinf.service.DepartamentoService;
import laboratorio.controleCoinf.service.Exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;


    @GetMapping("/{id}")
    public ResponseEntity<List<DepartamentoDto>> findAll(){
        List<DepartamentoDto> departamentoDtoList = departamentoService.findAll();
        return ResponseEntity.ok().body(departamentoDtoList);
    }

    @PostMapping
    public ResponseEntity<DepartamentoDto> insert(@Valid @RequestBody DepartamentoForm departamentoForm, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        DepartamentoDto departamentoDto = departamentoService.insert(departamentoForm);
        return ResponseEntity.ok().body(departamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDto> update(@Valid @RequestBody DepartamentoUpdateForm departamentoUpdateForm, @PathVariable("id") long id, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        DepartamentoDto departamentoDto = departamentoService.update(departamentoUpdateForm, id);
        return ResponseEntity.ok().body(departamentoDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
