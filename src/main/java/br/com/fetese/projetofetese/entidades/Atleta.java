package br.com.fetese.projetofetese.entidades;

import java.sql.Date;
import java.util.Objects;

public class Atleta extends Usuario{
    private Long idAtleta;
    private Long idKuk;
    private Long idFetese;
    private String nome;
    private String genero;
    private String cpf;
    private Long rg;
    private Long contato;
    private Date dataNasc;
    private String pcd;
    private String nacionalidade;
    private String naturalidade;
    private String graduacao;
    private String escolaridade;
    private String profissao;
    private String fotoPerfilUrl;
    private String certificadoUrl;
    private String pagamentoUrl;
    private Usuario usuario;
    private Endereco endereco;

    public Atleta(){
        super();
    }

    public Atleta(Long idUsuario, String email, Long idAtleta, Long idKuk, Long idFetese, String nome, String genero, String cpf, Long rg, Long contato, Date dataNasc, String pcd, String nacionalidade, String naturalidade, String graduacao, String escolaridade, String profissao, String fotoPerfilUrl, String certificadoUrl, String pagamentoUrl, Usuario usuario, Endereco endereco) {
        super.setIdUsuario(idUsuario);
        super.setEmail(email);
        this.idAtleta = idAtleta;
        this.idKuk = idKuk;
        this.idFetese = idFetese;
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.rg = rg;
        this.contato = contato;
        this.dataNasc = dataNasc;
        this.pcd = pcd;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.graduacao = graduacao;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.certificadoUrl = certificadoUrl;
        this.pagamentoUrl = pagamentoUrl;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public Long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Long idAtleta) {
        this.idAtleta = idAtleta;
    }

    public Long getIdKuk() {
        return idKuk;
    }

    public void setIdKuk(Long idKuk) {
        this.idKuk = idKuk;
    }

    public Long getIdFetese() {
        return idFetese;
    }

    public void setIdFetese(Long idFetese) {
        this.idFetese = idFetese;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public Long getContato() {
        return contato;
    }

    public void setContato(Long contato) {
        this.contato = contato;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public String getCertificadoUrl() {
        return certificadoUrl;
    }

    public void setCertificadoUrl(String certificadoUrl) {
        this.certificadoUrl = certificadoUrl;
    }

    public String getPagamentoUrl() {
        return pagamentoUrl;
    }

    public void setPagamentoUrl(String pagamentoUrl) {
        this.pagamentoUrl = pagamentoUrl;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return Objects.equals(idAtleta, atleta.idAtleta);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAtleta);
    }
}