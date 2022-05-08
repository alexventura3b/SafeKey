package safekey.model.bean;


public class Cliente {

    private int id_cliente;
    private String nm_cliente;
    private String cpf_cliente;
    private int id_Contatos;    
    private String dt_cadastro;
    private Contatos contatos;

    public Cliente(int id_cliente, String nm_cliente, String cpf_cliente, int id_Contatos, String dt_cadastro, Contatos contatos) {
        this.id_cliente = id_cliente;
        this.nm_cliente = nm_cliente;
        this.cpf_cliente = cpf_cliente;
        this.id_Contatos = id_Contatos;
        this.dt_cadastro = dt_cadastro;
        this.contatos = contatos;
    }

    public Cliente(int id_cliente, String nm_cliente, String cpf_cliente, int id_Contatos, String dt_cadastro) {
        this.id_cliente = id_cliente;
        this.nm_cliente = nm_cliente;
        this.cpf_cliente = cpf_cliente;
        this.id_Contatos = id_Contatos;
        this.dt_cadastro = dt_cadastro;
    }

    public Cliente(String nm_cliente, String cpf_cliente, String dt_cadastro) {
        this.nm_cliente = nm_cliente;
        this.cpf_cliente = cpf_cliente;
        this.dt_cadastro = dt_cadastro;
    }
    
    public Cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public int getId_Contatos() {
        return id_Contatos;
    }

    public void setId_Contatos(int id_Contatos) {
        this.id_Contatos = id_Contatos;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nm_cliente=" + nm_cliente + ", cpf_cliente=" + cpf_cliente + ", id_Contatos=" + id_Contatos + ", dt_cadastro=" + dt_cadastro + ", contatos=" + contatos + '}';
    }
    
    

}
