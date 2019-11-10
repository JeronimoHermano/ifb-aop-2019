package br.edu.ifb.aop.trabalho1.resources;

import br.edu.ifb.aop.trabalho1.domain.LoginDTO;
import br.edu.ifb.aop.trabalho1.domain.Pessoa;
import br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO;
import br.edu.ifb.aop.trabalho1.services.FormUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/forms")
public class FormUsuarioResource {

    @Autowired
    private FormUsuarioService service;

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/registrar")
    public Pessoa realizaRegistro(@Valid @RequestBody RegistraUsuarioDTO dto) {
        Pessoa pessoa = service.save(dto);
//        return new ResponseEntity<RegistraUsuarioDTO>(pessoa, HttpStatus.OK);
        return pessoa;
    }

    @PostMapping(value = "/login")
    public Pessoa login(@Valid @RequestBody LoginDTO dto) {
        return service.login(dto).getPessoa();
    }

}
