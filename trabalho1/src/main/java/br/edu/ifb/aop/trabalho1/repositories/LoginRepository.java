package br.edu.ifb.aop.trabalho1.repositories;

import br.edu.ifb.aop.trabalho1.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
}
