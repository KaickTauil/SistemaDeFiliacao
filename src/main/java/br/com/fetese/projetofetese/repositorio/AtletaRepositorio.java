package br.com.fetese.projetofetese.repositorio;

import br.com.fetese.projetofetese.entidades.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaRepositorio extends JpaRepository<Atleta, Long> {

    public Atleta findByIdFetese(Long idFetese);

}
