package br.com.fetese.projetofetese.repositorio;

import br.com.fetese.projetofetese.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}
