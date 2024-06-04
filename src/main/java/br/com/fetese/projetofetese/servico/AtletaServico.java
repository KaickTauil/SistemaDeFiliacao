package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.repositorio.AtletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaServico {

    @Autowired
    private AtletaRepositorio atletaRepositorio;

    public void salvarAtleta(Atleta atleta){

        atletaRepositorio.save(atleta);

    }
    public List<Atleta> findAll(){
        return atletaRepositorio.findAll();
    }
}
