package br.edu.ifb.aop.trabalho1.aspect;

import br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO;
import br.edu.ifb.aop.trabalho1.security.CryptSecurity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
public class SecurityAspect {

    CryptSecurity cryptSecurity = CryptSecurity.getInstance();

    @Before(value = "execution(* br.edu.ifb.aop.trabalho1.resources.FormUsuarioResource.realizaRegistro(..)) && args(req)")
    public void teste1(JoinPoint joinPoint, RegistraUsuarioDTO req) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        req.setSenha(cryptSecurity.sha256(req.getSenha()));
        System.out.println("AOP teste1: " + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO.setSenha(..))")
    public void teste2(JoinPoint joinPoint) {
        System.out.println("AOP teste2: " + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* br.edu.ifb.aop.trabalho1.domain.Pessoa.setNomeCompleto(..))")
    public void teste3(JoinPoint joinPoint) {
        System.out.println("AOP teste3: " + joinPoint.getSignature().getName());
    }

}
