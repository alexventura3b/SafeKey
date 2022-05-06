/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Compartimento {
    private int id_compartimento;
    private int num_compartimento;
    private int id_locker;
    private boolean status;//status geral para uso(exe:livre porém danificado);
    private boolean disponivel;//livre ou ocupado;
    private Locker locker;

    public Compartimento(int id_compartimento, int num_compartimento, int id_locker, boolean status, boolean disponivel, Locker locker) {
        this.id_compartimento = id_compartimento;
        this.num_compartimento = num_compartimento;
        this.id_locker = id_locker;
        this.status = status;
        this.disponivel = disponivel;
        this.locker = locker;
    }

    public Compartimento(int id_locker) {
        this.id_locker = id_locker;
    }

    public int getId_compartimento() {
        return id_compartimento;
    }

    public void setId_compartimento(int id_compartimento) {
        this.id_compartimento = id_compartimento;
    }

    public int getNum_compartimento() {
        return num_compartimento;
    }

    public void setNum_compartimento(int num_compartimento) {
        this.num_compartimento = num_compartimento;
    }

    public int getId_locker() {
        return id_locker;
    }

    public void setId_locker(int id_locker) {
        this.id_locker = id_locker;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    @Override
    public String toString() {
        return "Compartimento{" + "id_compartimento=" + id_compartimento + ", num_compartimento=" + num_compartimento + ", id_locker=" + id_locker + ", status=" + status + ", disponivel=" + disponivel + ", locker=" + locker + '}';
    }
    
}
