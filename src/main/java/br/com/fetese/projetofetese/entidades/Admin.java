package br.com.fetese.projetofetese.entidades;

import java.util.List;
import java.util.Objects;

public class Admin extends Usuario{
    private Long idAdmin;
    private Usuario usuario;

    public Admin() {
        super();
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(idAdmin, admin.idAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idAdmin);
    }
}
