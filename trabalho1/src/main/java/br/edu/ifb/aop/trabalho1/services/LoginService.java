package br.edu.ifb.aop.trabalho1.services;

import br.edu.ifb.aop.trabalho1.domain.Login;
import br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO;
import br.edu.ifb.aop.trabalho1.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public Login save(RegistraUsuarioDTO dto) {
        Login login = new Login(null, dto.getLogin(), dto.getSenha());
        login = repository.save(login);
        return login;
    }

}
