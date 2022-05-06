/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.bean;

/**
 *
 * @author User
 */
public class AcessoSuporte {
private int idacesso;
    private String id_func;//matrícula do funcionário
    private String usuario;
    private String senha;
    private String dt_criacao;
    private Suporte suporte;//objeto funcionário já instanciado (this)

    public AcessoSuporte(String id_func) {
        this.id_func = id_func;
    }

    public AcessoSuporte(int idacesso, String id_func, String usuario, String senha, String dt_criacao, Suporte suporte) {
        this.idacesso = idacesso;
        this.id_func = id_func;
        this.usuario = usuario;
        this.senha = senha;
        this.dt_criacao = dt_criacao;
        this.suporte = suporte;
    }

    public AcessoSuporte(int idacesso, String id_func, String usuario, String senha, String dt_criacao) {
        this.idacesso = idacesso;
        this.id_func = id_func;
        this.usuario = usuario;
        this.senha = senha;
        this.dt_criacao = dt_criacao;
    }

    public int getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(int idacesso) {
        this.idacesso = idacesso;
    }

    public String getId_func() {
        return id_func;
    }

    public void setId_func(String id_func) {
        this.id_func = id_func;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Suporte getSuporte() {
        return suporte;
    }

    public void setSuporte(Suporte suporte) {
        this.suporte = suporte;
    }

    @Override
    public String toString() {
        return "AcessoSuporte{" + "idacesso=" + idacesso + ", id_func=" + id_func + ", usuario=" + usuario + ", senha=" + senha + ", dt_criacao=" + dt_criacao + ", suporte=" + suporte + '}';
    }
    

}
