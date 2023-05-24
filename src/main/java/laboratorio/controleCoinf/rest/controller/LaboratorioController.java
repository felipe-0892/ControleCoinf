package laboratorio.controleCoinf.rest.controller;


import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.LaboratorioDto;
import laboratorio.controleCoinf.rest.form.LaboratorioForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.LaboratorioUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.ConstraintException;
import laboratorio.controleCoinf.service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping("/{id}")
    public ResponseEntity<List<LaboratorioDto>> findAll(){
        List<LaboratorioDto> laboratorioDtoList = laboratorioService.findAll();
        return ResponseEntity.ok().body(laboratorioDtoList);
    }

    @PostMapping
    public ResponseEntity<LaboratorioDto> insert(@Valid @RequestBody LaboratorioForm laboratorioForm, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        LaboratorioDto laboratorioDto = laboratorioService.insert(laboratorioForm);
        return ResponseEntity.ok().body(laboratorioDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LaboratorioDto> update(@Valid @RequestBody LaboratorioUpdateForm laboratorioUpdateForm, @PathVariable("id") long id, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        LaboratorioDto laboratorioDto = laboratorioService.update(laboratorioUpdateForm, id);
        return ResponseEntity.ok().body(laboratorioDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        laboratorioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
