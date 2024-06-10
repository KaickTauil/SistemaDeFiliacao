package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Admin;
import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.excecoes.ResourceNotFoudException;
import br.com.fetese.projetofetese.repositorio.AdminRepositorio;
import br.com.fetese.projetofetese.repositorio.AtletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServico {

    @Autowired
    private AdminRepositorio adminRepositorio;

    @Autowired
    private AtletaRepositorio atletaRepositorio;

    @Autowired
    private AtletaServico atletaServico;

    public void salvarAdmin(Admin admin) {
        adminRepositorio.save(admin);
    }

    //somente admins podem visualisar a lista de atletas
    public List<Atleta> listarAtletas() {
        return atletaRepositorio.findAll();
    }

    public Atleta encontrarAtletaPorId(Long id) {
        return atletaRepositorio.findById(id).orElseThrow();
    }

    public Atleta encontrarAtletaPorIdFetese(Long idFetese) {
        return atletaRepositorio.findByIdFetese(idFetese);
    }

    public void AtualizarAtleta(Long idAtleta, String graduação, String academia, String profissao, String Pcd) {
        Atleta atleta = atletaRepositorio.findById(idAtleta).orElseThrow();
        atleta.setGraduacao(graduação);
        atleta.setAcademia(academia);
        atleta.setProfissao(profissao);
        atleta.setPcd(Pcd);
        atletaRepositorio.save(atleta);
    }

    //somente admins podem excluir atletas
    public void excluirAtleta(Long id) {
        Atleta atleta = atletaRepositorio.findById(id).orElseThrow();
        atletaRepositorio.delete(atleta);

    }

}




