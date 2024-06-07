package br.com.fetese.projetofetese.controladores;

import br.com.fetese.projetofetese.entidades.Admin;
import br.com.fetese.projetofetese.entidades.Atleta;
import br.com.fetese.projetofetese.servico.AdminServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminControlador {

    @Autowired
    private AdminServico adminServico;

    @GetMapping("/formAdmin")
    public String formAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/cadastroAdmin";
    }

    @PostMapping("/salvarAdmin")
    public String salvarAdmin(@ModelAttribute Admin admin) {
        adminServico.salvarAdmin(admin);
        return "admin/loginAdmin";
    }

    @GetMapping("/exibirAtletas")
    public String exibirAtletas(Model model) {
        List<Atleta> atletas = adminServico.listarAtletas();
        model.addAttribute("atletas", atletas);
        return "admin/listAtletas";
    }

    @GetMapping("/{idFetese}")
    public String exibirAtletasPorCpf(@PathVariable Long idFetese, Model model) {
        Atleta atleta = adminServico.encontrarAtletaPorIdFetese(idFetese);


        if( idFetese != null && atleta.getIdFetese() == idFetese) {
            model.addAttribute("atletas", atleta);
            return "admin/listAtletas";
        }else {
            return "/redirect:/ExibirAtletas";
        }
    }
    @DeleteMapping("/{id}")
    public String excluirAtleta(@PathVariable Long id) {

        try {
            adminServico.excluirAtleta(id);
            return "/exibirAtletas";
        }catch (DataIntegrityViolationException e) {
            e.getMessage();
            return "/exibirAtletas";
        }

    }
}