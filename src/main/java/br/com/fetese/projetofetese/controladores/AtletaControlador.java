package br.com.fetese.projetofetese.controladores;

import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.entidades.Endereco;
import br.com.fetese.projetofetese.servico.AtletaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class AtletaControlador {

    @Autowired
    private AtletaServico atletaServico;

    @GetMapping("/form")
    public String form(Model model) {
        Atleta atleta = new Atleta();
        Endereco endereco = new Endereco();
        endereco.setAtletas(atleta);
        atleta.setEndereco(endereco);
        model.addAttribute("atleta", atleta);
        return "atleta/index";

    }
    @PostMapping("/salvarAtleta")
    public String salvarAtletas(@ModelAttribute Atleta atleta,@RequestParam("imagemPerfil") MultipartFile imagemPerfil,
                                @RequestParam("imagemCertificado") MultipartFile imagemCertificado,
                                @RequestParam("imagemComprovante") MultipartFile imagemComprovante) {

        try{
            atleta.getEndereco().setAtletas(atleta);
            atletaServico.salvarAtleta(atleta, imagemPerfil, imagemCertificado, imagemComprovante);
            System.out.println("Atleta salvo com sucesso");
            return "/atleta/index";
        }catch (IOException e){
            return  "/erro" ;
        }

    }

}
