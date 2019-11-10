package br.edu.ifb.aop.trabalho1.services;

import br.edu.ifb.aop.trabalho1.domain.Login;
import br.edu.ifb.aop.trabalho1.domain.Pessoa;
import br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO;
import br.edu.ifb.aop.trabalho1.repositories.LoginRepository;
import br.edu.ifb.aop.trabalho1.repositories.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormUsuarioService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LoginRepository loginRepository;

    public Pessoa find(Integer id) {
        Optional<Pessoa> opt = pessoaRepository.findById(id);
        return opt.orElseThrow(() ->
                new ObjectNotFoundException(null,
                        "Objeto nao encontrado - ID: " + id + ", Tipo: " +
                                Pessoa.class.getName())
        );
    }

    public Pessoa save(RegistraUsuarioDTO dto) {
        Pessoa pessoa = new Pessoa(null, dto.getNomeCompleto(), dto.getTelefone());
        Login login = new Login(null, dto.getLogin(), dto.getSenha());

        pessoa.getLogins().add(login);
        login.setPessoa(pessoa);

        pessoa = pessoaRepository.save(pessoa);
        login = loginRepository.save(login);

        return pessoa;
    }

}
