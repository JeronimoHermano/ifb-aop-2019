package br.edu.ifb.aop.trabalho1.services;

import br.edu.ifb.aop.trabalho1.domain.Pessoa;
import br.edu.ifb.aop.trabalho1.repositories.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormUsuarioService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa find(Integer id) {
        Optional<Pessoa> opt = repository.findById(id);
        return opt.orElseThrow(() ->
                new ObjectNotFoundException(null,
                        "Objeto nao encontrado - ID: " + id + ", Tipo: " +
                                Pessoa.class.getName())
        );
    }

}
