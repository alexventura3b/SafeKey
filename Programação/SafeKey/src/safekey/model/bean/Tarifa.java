/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Tarifa {
    private int id_tarifa;
    private String nm_tarifa;// descrição simples tarifa
    private double vlr_tarifa;//valor da tarifa
    private String dt_implatacao;
    private String obs_tarifa;// obs não obrigatória
    private Suporte suporte;// funcionário que autorizou/implantou a tarifa
    private double time_tarifa;//tempo ou multiplicador do vlr da tarifa;

    public Tarifa(int id_tarifa, String nm_tarifa, double vlr_tarifa, String dt_implatacao, String obs_tarifa, Suporte suporte, double time_tarifa) {
        this.id_tarifa = id_tarifa;
        this.nm_tarifa = nm_tarifa;
        this.vlr_tarifa = vlr_tarifa;
        this.dt_implatacao = dt_implatacao;
        this.obs_tarifa = obs_tarifa;
        this.suporte = suporte;
        this.time_tarifa = time_tarifa;
    }

    public Tarifa(String nm_tarifa) {
        this.nm_tarifa = nm_tarifa;
    }

    public Tarifa(Suporte suporte) {
        this.suporte = suporte;
    }

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getNm_tarifa() {
        return nm_tarifa;
    }

    public void setNm_tarifa(String nm_tarifa) {
        this.nm_tarifa = nm_tarifa;
    }

    public double getVlr_tarifa() {
        return vlr_tarifa;
    }

    public void setVlr_tarifa(double vlr_tarifa) {
        this.vlr_tarifa = vlr_tarifa;
    }

    public String getDt_implatacao() {
        return dt_implatacao;
    }

    public void setDt_implatacao(String dt_implatacao) {
        this.dt_implatacao = dt_implatacao;
    }

    public String getObs_tarifa() {
        return obs_tarifa;
    }

    public void setObs_tarifa(String obs_tarifa) {
        this.obs_tarifa = obs_tarifa;
    }

    public Suporte getSuporte() {
        return suporte;
    }

    public void setSuporte(Suporte suporte) {
        this.suporte = suporte;
    }

    public double getTime_tarifa() {
        return time_tarifa;
    }

    public void setTime_tarifa(double time_tarifa) {
        this.time_tarifa = time_tarifa;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "id_tarifa=" + id_tarifa + ", nm_tarifa=" + nm_tarifa + ", vlr_tarifa=" + vlr_tarifa + ", dt_implatacao=" + dt_implatacao + ", obs_tarifa=" + obs_tarifa + ", suporte=" + suporte + ", time_tarifa=" + time_tarifa + '}';
    }
    
    
}
