package br.com.fetese.projetofetese.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="administrador")
public class Admin extends Usuario implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    public Admin() {
        super();
    }

    public Admin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(Long idUsuario, String email, String senha, Long idAdmin) {
        super(idUsuario, email, senha);
        this.idAdmin = idAdmin;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
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
