package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.excecoes.ImageException;
import br.com.fetese.projetofetese.repositorio.AtletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class AtletaServico {

    @Autowired
    private AtletaRepositorio atletaRepositorio;

    //Por favor não se assuste, pretendo otimizar esse codigo em logo logo
    public void salvarAtleta(Atleta atleta, MultipartFile imagemPerfil, MultipartFile imagemCertificado, MultipartFile imagemComprovante) throws IOException {
        if(imagemPerfil.isEmpty() || imagemCertificado.isEmpty() || imagemComprovante.isEmpty()){
            throw new ImageException("Os campos de imagem não podem estar vazios");
        }

        atleta.setFotoPerfilUrl(renomearImagem(atleta, imagemPerfil, "PERFIL"));
        atleta.setCertificadoUrl(renomearImagem(atleta, imagemCertificado, "CERTIFICADO"));
        atleta.setPagamentoUrl(renomearImagem(atleta, imagemComprovante, "COMPROVANTE"));


        String perfilDir = "static/imagens/imagensPerfil/";
        String certificadoDir = "static/imagens/imagensCertificado/";
        String comprovanteDir = "static/imagens/imagensComprovante/";

       Path nomeImagemPerfilDir = Paths.get(perfilDir);
       Path nomeImagemCertificadoDir = Paths.get(certificadoDir);
       Path nomeImagemComprovanteDir= Paths.get(comprovanteDir);

       if(!Files.exists(nomeImagemPerfilDir)){
           Files.createDirectories(nomeImagemPerfilDir);
       }
       if(!Files.exists(nomeImagemCertificadoDir)){
            Files.createDirectories(nomeImagemCertificadoDir);
       }
       if(!Files.exists(nomeImagemComprovanteDir)){
            Files.createDirectories(nomeImagemComprovanteDir);
       }

       Path imagemPerfilPath = nomeImagemPerfilDir.resolve(atleta.getFotoPerfilUrl());
       Path imagemCertificadoPath = nomeImagemCertificadoDir.resolve(atleta.getCertificadoUrl());
       Path imagemComprovantePath = nomeImagemComprovanteDir.resolve(atleta.getCertificadoUrl());




       try (InputStream perfilInputStream = imagemPerfil.getInputStream();
        InputStream certificadoInputStream = imagemCertificado.getInputStream();
        InputStream comprovanteInputStream = imagemComprovante.getInputStream()) {

            Files.copy(perfilInputStream, imagemPerfilPath, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(certificadoInputStream, imagemCertificadoPath, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(comprovanteInputStream, imagemComprovantePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new ImageException("Ocorreu um erro ao salvar uma das imagens");
        }

        atletaRepositorio.save(atleta);

    }
    public List<Atleta> findAll(){
        return atletaRepositorio.findAll();
    }


    //Metodo para definir um novo nome a partir dos parametros do atleta para o arquivo de imagem
    public String renomearImagem(Atleta atleta, MultipartFile imagem, String tipo) throws IOException {
        // extrair o nome original do arquivo
        String nomeImagemOriginal = StringUtils.cleanPath(imagem.getOriginalFilename());

        //extrair extensão do arquivo
        String extensao = "";
        int armIndex = nomeImagemOriginal.lastIndexOf('.');
        if(armIndex > 0){
            extensao = nomeImagemOriginal.substring(armIndex);
        }

        //novo nome do arquivo a partir dos atributors do atleta
        String novoNomeImagem = tipo + atleta.getNome().trim() + atleta.getCpf() + extensao;

        return novoNomeImagem;
    }



}
