package br.edu.ifb.aop.trabalho1.aspect;

import br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
public class SecurityAspect {

    @Before(value = "execution(* br.edu.ifb.aop.trabalho1.resources.FormUsuarioResource.realizaRegistro(..)) and args(req)")
    public void teste1(JoinPoint joinPoint, RegistraUsuarioDTO req) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = digest.digest(req.getSenha().getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        req.setSenha(hexString.toString());

        System.out.println("AOP teste1: " + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* br.edu.ifb.aop.trabalho1.domain.RegistraUsuarioDTO.getSenha(..))")
    public void teste2(JoinPoint joinPoint) {
        System.out.println("AOP teste2: " + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* br.edu.ifb.aop.trabalho1.domain.Pessoa.setNomeCompleto(..))")
    public void teste3(JoinPoint joinPoint) {
        System.out.println("AOP teste3: " + joinPoint.getSignature().getName());
    }

}
