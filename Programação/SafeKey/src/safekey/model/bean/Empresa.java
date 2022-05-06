/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class Empresa {
    private int id_empresa;
    private String nm_empresa;
    private String razaosocial;//caso haja filiais ou junções/parcerias
    private String cnpj;//para fins de nota fiscal
    private double capitalsocial;
    private int id_contato;//dados de endereço da empresa ou coligada (necessários para nota)
    private String isnc_estadual;//incrição estadual (ICMS)
    private Contatos contatos;//chamada do objeto contatos

    public Empresa(int id_empresa, String nm_empresa, String razaosocial, String cnpj, double capitalsocial, int id_contato, String isnc_estadual, Contatos contatos) {
        this.id_empresa = id_empresa;
        this.nm_empresa = nm_empresa;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.capitalsocial = capitalsocial;
        this.id_contato = id_contato;
        this.isnc_estadual = isnc_estadual;
        this.contatos = contatos;
    }

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNm_empresa() {
        return nm_empresa;
    }

    public void setNm_empresa(String nm_empresa) {
        this.nm_empresa = nm_empresa;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getCapitalsocial() {
        return capitalsocial;
    }

    public void setCapitalsocial(double capitalsocial) {
        this.capitalsocial = capitalsocial;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getIsnc_estadual() {
        return isnc_estadual;
    }

    public void setIsnc_estadual(String isnc_estadual) {
        this.isnc_estadual = isnc_estadual;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id_empresa=" + id_empresa + ", nm_empresa=" + nm_empresa + ", razaosocial=" + razaosocial + ", cnpj=" + cnpj + ", capitalsocial=" + capitalsocial + ", id_contato=" + id_contato + ", isnc_estadual=" + isnc_estadual + ", contatos=" + contatos + '}';
    }
    

}
