package br.edu.ifb.aop.trabalho1.aspect;

import br.edu.ifb.aop.trabalho1.domain.LoginDTO;
import br.edu.ifb.aop.trabalho1.security.CryptSecurity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
public class LoginAspect {

    CryptSecurity cryptSecurity = CryptSecurity.getInstance();

    @Before(value = "execution(* br.edu.ifb.aop.trabalho1.resources.FormUsuarioResource.login(..)) && args(dto)")
    public void teste1(JoinPoint joinPoint, LoginDTO dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        dto.setSenha(cryptSecurity.sha256(dto.getSenha()));
        System.out.println("AOP login: " + joinPoint.getSignature().getName());
    }

}
