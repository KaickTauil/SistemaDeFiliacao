package br.com.fetese.projetofetese.servico;

import br.com.fetese.projetofetese.entidades.Admin;
import br.com.fetese.projetofetese.repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServico {

    @Autowired
    private AdminRepositorio adminRepositorio;

    public void saveAdmin(Admin admin) {
        adminRepositorio.save(admin);
    }
}
