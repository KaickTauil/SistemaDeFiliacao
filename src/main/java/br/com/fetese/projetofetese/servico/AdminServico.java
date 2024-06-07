package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Admin;
import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.repositorio.AdminRepositorio;
import br.com.fetese.projetofetese.repositorio.AtletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServico {

    @Autowired
    private AdminRepositorio adminRepositorio;

    @Autowired
    private AtletaRepositorio atletaRepositorio;

    public void salvarAdmin(Admin admin) {
        adminRepositorio.save(admin);
    }

    //somente admins podem visualisar a lista de atletas
    public List<Atleta> listarAtletas(){
       return atletaRepositorio.findAll();
    }

    public Atleta encontrarAtletaPorId(Long id){
        return atletaRepositorio.findById(id).orElseThrow();
    }

    public Atleta encontrarAtletaPorIdFetese(Long idFetese){
        return atletaRepositorio.findByIdFetese(idFetese);
    }


    //somente admins podem excluir atletas
    public void excluirAtleta(Long id) {
        Atleta atleta = atletaRepositorio.findById(id).orElseThrow();
        atletaRepositorio.delete(atleta);

    }


}
