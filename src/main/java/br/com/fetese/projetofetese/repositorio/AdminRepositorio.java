package br.com.fetese.projetofetese.repositorio;

import br.com.fetese.projetofetese.entidades.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositorio extends JpaRepository<Admin, Long> {
}
