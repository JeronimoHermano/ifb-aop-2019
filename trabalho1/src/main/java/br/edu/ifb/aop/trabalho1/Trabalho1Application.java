package br.edu.ifb.aop.trabalho1;

import br.edu.ifb.aop.trabalho1.domain.Login;
import br.edu.ifb.aop.trabalho1.domain.Pessoa;
import br.edu.ifb.aop.trabalho1.repositories.LoginRepository;
import br.edu.ifb.aop.trabalho1.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Trabalho1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Trabalho1Application.class, args);
    }

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void run(String... args) throws Exception {
        Pessoa pessoa = new Pessoa(null, "João da Silva", "+55 62 99999-9999");
        Login login = new Login(null, "meu@email.com", "senhaSegura");

        pessoa.getLogins().add(login);
        login.setPessoa(pessoa);

        pessoaRepository.save(pessoa);
        loginRepository.save(login);
    }
}
