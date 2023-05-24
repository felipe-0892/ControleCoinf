package laboratorio.controleCoinf.rest.controller;

import jakarta.validation.Valid;
import laboratorio.controleCoinf.rest.dto.PessoaDto;
import laboratorio.controleCoinf.rest.form.PessoaForm;
import laboratorio.controleCoinf.rest.form.UpdateForms.PessoaUpdateForm;
import laboratorio.controleCoinf.service.Exceptions.ConstraintException;
import laboratorio.controleCoinf.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<PessoaDto>> findAll(){
        List<PessoaDto> pessoaDtoList = pessoaService.findAll();
        return ResponseEntity.ok().body(pessoaDtoList);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> insert(@Valid @RequestBody PessoaForm pessoaForm, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        PessoaDto pessoaDto = pessoaService.insert(pessoaForm);
        return ResponseEntity.ok().body(pessoaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> update(@Valid @RequestBody PessoaUpdateForm pessoaUpdateForm, @PathVariable("id") String id, BindingResult br) throws ConstraintException{
        if (br.hasErrors()){
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        }
        PessoaDto pessoaDto = pessoaService.update(pessoaUpdateForm, new String(id));
        return ResponseEntity.ok().body(pessoaDto);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        // pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
