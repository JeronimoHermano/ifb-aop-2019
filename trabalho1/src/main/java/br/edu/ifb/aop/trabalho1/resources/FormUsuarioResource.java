package br.edu.ifb.aop.trabalho1.resources;

import br.edu.ifb.aop.trabalho1.domain.Pessoa;
import br.edu.ifb.aop.trabalho1.services.FormUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/form")
public class FormUsuarioResource {

    @Autowired
    private FormUsuarioService service;

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
