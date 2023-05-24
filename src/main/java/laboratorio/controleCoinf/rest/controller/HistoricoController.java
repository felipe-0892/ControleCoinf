package laboratorio.controleCoinf.rest.controller;

import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.HistoricoDto;
import laboratorio.controleCoinf.rest.form.HistoricoForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.HistoricoUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.ConstraintException;
import laboratorio.controleCoinf.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<HistoricoDto>> findAll(){
        List<HistoricoDto> historicoDtoList = historicoService.findAll();
        return ResponseEntity.ok().body(historicoDtoList);
    }

    @PostMapping
    public ResponseEntity<HistoricoDto> insert(@Valid @RequestBody HistoricoForm historicoForm, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        HistoricoDto historicoDto = historicoService.insert(historicoForm);
        return ResponseEntity.ok().body(historicoDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HistoricoDto> update(@Valid @RequestBody HistoricoUpdateForm historicoUpdateForm, @PathVariable("id") long id, BindingResult br) throws  ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        HistoricoDto historicoDto =historicoService.update(historicoUpdateForm, id);
        return ResponseEntity.ok().body(historicoDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") LocalDate id){
        historicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
