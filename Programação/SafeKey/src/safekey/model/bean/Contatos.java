/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Contatos {
    private int id_contato;
    private String end_pais;
    private String end_estado;
    private String end_cidade;
    private String end_bairro;
    private String end_rua;
    private int end_num;
    private int num_apt;//numero apartamento e/ou bloco(opcional)
    private String end_cep;
    private String tel_cod_pais;//código ddi pais(pode haver 2)
    private String tel_ddd;//código ddd pais(pode haver 2)
    private String tel;//(pode haver 2)
    private String email;//(pode haver 2)
    private String dt_nasc;//data de nascimento

    public Contatos(int id_contato, String end_pais, String end_estado, String end_cidade, String end_bairro, String end_rua, int end_num, int num_apt, String end_cep, String tel_cod_pais, String tel_ddd, String tel, String email, String dt_nasc) {
        this.id_contato = id_contato;
        this.end_pais = end_pais;
        this.end_estado = end_estado;
        this.end_cidade = end_cidade;
        this.end_bairro = end_bairro;
        this.end_rua = end_rua;
        this.end_num = end_num;
        this.num_apt = num_apt;
        this.end_cep = end_cep;
        this.tel_cod_pais = tel_cod_pais;
        this.tel_ddd = tel_ddd;
        this.tel = tel;
        this.email = email;
        this.dt_nasc = dt_nasc;
    }

    public Contatos(String email) {
        this.email = email;
    }

    public Contatos(String tel_cod_pais, String tel_ddd, String tel) {
        this.tel_cod_pais = tel_cod_pais;
        this.tel_ddd = tel_ddd;
        this.tel = tel;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getEnd_pais() {
        return end_pais;
    }

    public void setEnd_pais(String end_pais) {
        this.end_pais = end_pais;
    }

    public String getEnd_estado() {
        return end_estado;
    }

    public void setEnd_estado(String end_estado) {
        this.end_estado = end_estado;
    }

    public String getEnd_cidade() {
        return end_cidade;
    }

    public void setEnd_cidade(String end_cidade) {
        this.end_cidade = end_cidade;
    }

    public String getEnd_bairro() {
        return end_bairro;
    }

    public void setEnd_bairro(String end_bairro) {
        this.end_bairro = end_bairro;
    }

    public String getEnd_rua() {
        return end_rua;
    }

    public void setEnd_rua(String end_rua) {
        this.end_rua = end_rua;
    }

    public int getEnd_num() {
        return end_num;
    }

    public void setEnd_num(int end_num) {
        this.end_num = end_num;
    }

    public int getNum_apt() {
        return num_apt;
    }

    public void setNum_apt(int num_apt) {
        this.num_apt = num_apt;
    }

    public String getEnd_cep() {
        return end_cep;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }

    public String getTel_cod_pais() {
        return tel_cod_pais;
    }

    public void setTel_cod_pais(String tel_cod_pais) {
        this.tel_cod_pais = tel_cod_pais;
    }

    public String getTel_ddd() {
        return tel_ddd;
    }

    public void setTel_ddd(String tel_ddd) {
        this.tel_ddd = tel_ddd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    @Override
    public String toString() {
        return "Contatos{" + "id_contato=" + id_contato + ", end_pais=" + end_pais + ", end_estado=" + end_estado + ", end_cidade=" + end_cidade + ", end_bairro=" + end_bairro + ", end_rua=" + end_rua + ", end_num=" + end_num + ", num_apt=" + num_apt + ", end_cep=" + end_cep + ", tel_cod_pais=" + tel_cod_pais + ", tel_ddd=" + tel_ddd + ", tel=" + tel + ", email=" + email + ", dt_nasc=" + dt_nasc + '}';
    }
      
    
}
