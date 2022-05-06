/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Suporte {
    private int id_suporte;
    private String mt_funcionario;
    private String nm_funcinario;
    private String setor;
    private String nivel;
    private String cargo;
    private int id_contato;
    private String dt_contratado;
    private Contatos contato;
    private Empresa empresa;

    public Suporte(int id_suporte, String mt_funcionario, String nm_funcinario, String setor, String nivel, String cargo, int id_contato, String dt_contratado, Contatos contato, Empresa empresa) {
        this.id_suporte = id_suporte;
        this.mt_funcionario = mt_funcionario;
        this.nm_funcinario = nm_funcinario;
        this.setor = setor;
        this.nivel = nivel;
        this.cargo = cargo;
        this.id_contato = id_contato;
        this.dt_contratado = dt_contratado;
        this.contato = contato;
        this.empresa = empresa;
    }

    public Suporte(int id_suporte, String mt_funcionario, String nm_funcinario, String setor, String nivel, String cargo, int id_contato, String dt_contratado) {
        this.id_suporte = id_suporte;
        this.mt_funcionario = mt_funcionario;
        this.nm_funcinario = nm_funcinario;
        this.setor = setor;
        this.nivel = nivel;
        this.cargo = cargo;
        this.id_contato = id_contato;
        this.dt_contratado = dt_contratado;
    }

    public Suporte(String mt_funcionario) {
        this.mt_funcionario = mt_funcionario;
    }

    public int getId_suporte() {
        return id_suporte;
    }

    public void setId_suporte(int id_suporte) {
        this.id_suporte = id_suporte;
    }

    public String getMt_funcionario() {
        return mt_funcionario;
    }

    public void setMt_funcionario(String mt_funcionario) {
        this.mt_funcionario = mt_funcionario;
    }

    public String getNm_funcinario() {
        return nm_funcinario;
    }

    public void setNm_funcinario(String nm_funcinario) {
        this.nm_funcinario = nm_funcinario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getDt_contratado() {
        return dt_contratado;
    }

    public void setDt_contratado(String dt_contratado) {
        this.dt_contratado = dt_contratado;
    }

    public Contatos getContato() {
        return contato;
    }

    public void setContato(Contatos contato) {
        this.contato = contato;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Suporte{" + "id_suporte=" + id_suporte + ", mt_funcionario=" + mt_funcionario + ", nm_funcinario=" + nm_funcinario + ", setor=" + setor + ", nivel=" + nivel + ", cargo=" + cargo + ", id_contato=" + id_contato + ", dt_contratado=" + dt_contratado + ", contato=" + contato + ", empresa=" + empresa + '}';
    }
    
    
}
