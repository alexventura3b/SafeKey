/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class AcessoCliente {
    private int id_acesso;
    private String id_cliente;
    private String usuario;
    private String senha;
    private String dt_criacao;
    private Cliente Cliente;

    public AcessoCliente(int id_acesso, String id_cliente, String usuario, String senha, String dt_criacao, Cliente Cliente) {
        this.id_acesso = id_acesso;
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.senha = senha;
        this.dt_criacao = dt_criacao;
        this.Cliente = Cliente;
    }

    public AcessoCliente(int id_acesso, String id_cliente, String usuario, String senha, String dt_criacao) {
        this.id_acesso = id_acesso;
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.senha = senha;
        this.dt_criacao = dt_criacao;
    }

    public AcessoCliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_acesso() {
        return id_acesso;
    }

    public void setId_acesso(int id_acesso) {
        this.id_acesso = id_acesso;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
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

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    @Override
    public String toString() {
        return "AcessoCliente{" + "id_acesso=" + id_acesso + ", id_cliente=" + id_cliente + ", usuario=" + usuario + ", senha=" + senha + ", dt_criacao=" + dt_criacao + ", Cliente=" + Cliente + '}';
    }
    
   
}
