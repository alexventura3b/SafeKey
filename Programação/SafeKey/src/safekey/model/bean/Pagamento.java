/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Pagamento {
    private int id_pagamento;
    private String forma_pag;
    private String dt_pag;
    private boolean status_pag;
    private double vlr_pag;

    public Pagamento(int id_pagamento, String forma_pag, String dt_pag, boolean status_pag, double vlr_pag) {
        this.id_pagamento = id_pagamento;
        this.forma_pag = forma_pag;
        this.dt_pag = dt_pag;
        this.status_pag = status_pag;
        this.vlr_pag = vlr_pag;
    }

    public Pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getForma_pag() {
        return forma_pag;
    }

    public void setForma_pag(String forma_pag) {
        this.forma_pag = forma_pag;
    }

    public String getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(String dt_pag) {
        this.dt_pag = dt_pag;
    }

    public boolean isStatus_pag() {
        return status_pag;
    }

    public void setStatus_pag(boolean status_pag) {
        this.status_pag = status_pag;
    }

    public double getVlr_pag() {
        return vlr_pag;
    }

    public void setVlr_pag(double vlr_pag) {
        this.vlr_pag = vlr_pag;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id_pagamento=" + id_pagamento + ", forma_pag=" + forma_pag + ", dt_pag=" + dt_pag + ", status_pag=" + status_pag + ", vlr_pag=" + vlr_pag + '}';
    }
    
    
}
