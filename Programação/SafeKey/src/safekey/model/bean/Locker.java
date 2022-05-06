/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Locker {
    private int id_locker;//contador simples do bd;
    private int num_locker;//identificador único/reg (chave banco de dados);
    private String endereco;
    private String cidade;
    private String obs_locker;
    private String dt_instalacao;
    private boolean status;//locker por completo(exe:superlotação dos compartimentos);
    private String id_Suporte;//suporte responsavél pelo locker;
    private String id_empresa;
    private Suporte suporte;
    private Empresa empresa;

    public Locker(int id_locker, int num_locker, String endereco, String cidade, String obs_locker, String dt_instalacao, boolean status, String id_Suporte, String id_empresa, Suporte suporte, Empresa empresa) {
        this.id_locker = id_locker;
        this.num_locker = num_locker;
        this.endereco = endereco;
        this.cidade = cidade;
        this.obs_locker = obs_locker;
        this.dt_instalacao = dt_instalacao;
        this.status = status;
        this.id_Suporte = id_Suporte;
        this.id_empresa = id_empresa;
        this.suporte = suporte;
        this.empresa = empresa;
    }

    public Locker(int num_locker) {
        this.num_locker = num_locker;
    }

    public Locker(String id_Suporte) {
        this.id_Suporte = id_Suporte;
    }

    public int getId_locker() {
        return id_locker;
    }

    public void setId_locker(int id_locker) {
        this.id_locker = id_locker;
    }

    public int getNum_locker() {
        return num_locker;
    }

    public void setNum_locker(int num_locker) {
        this.num_locker = num_locker;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getObs_locker() {
        return obs_locker;
    }

    public void setObs_locker(String obs_locker) {
        this.obs_locker = obs_locker;
    }

    public String getDt_instalacao() {
        return dt_instalacao;
    }

    public void setDt_instalacao(String dt_instalacao) {
        this.dt_instalacao = dt_instalacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId_Suporte() {
        return id_Suporte;
    }

    public void setId_Suporte(String id_Suporte) {
        this.id_Suporte = id_Suporte;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Suporte getSuporte() {
        return suporte;
    }

    public void setSuporte(Suporte suporte) {
        this.suporte = suporte;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Locker{" + "id_locker=" + id_locker + ", num_locker=" + num_locker + ", endereco=" + endereco + ", cidade=" + cidade + ", obs_locker=" + obs_locker + ", dt_instalacao=" + dt_instalacao + ", status=" + status + ", id_Suporte=" + id_Suporte + ", id_empresa=" + id_empresa + ", suporte=" + suporte + ", empresa=" + empresa + '}';
    }
    
    
}
