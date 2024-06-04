package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fetese.projetofetese.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    public void saveEndereco(Endereco endereco) {
        enderecoRepositorio.save(endereco);
    }


}
