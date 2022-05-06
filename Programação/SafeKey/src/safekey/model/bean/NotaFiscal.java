/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.model.bean;

/**
 *
 * @author alexv
 */
public class NotaFiscal {
    private int id_notafiscal;
    private String num_notafiscal;//varbinary no BD;
    private String id_cliente;//cliente do serviço;
    private String id_empresa;//id da empresa prestadora do serviço, caso haja matrizes ou agregações
    private int id_servico;//numero do contrato que na nota entra como servico
    private Cliente cliente;//objeto cliente
    private Empresa empresa;// objeto empresa
    private ClienteLocker ClienteLocker;//objeto contrato cliente locker

    public NotaFiscal(int id_notafiscal, String num_notafiscal, String id_cliente, String id_empresa, int id_servico, Cliente cliente, Empresa empresa, ClienteLocker ClienteLocker) {
        this.id_notafiscal = id_notafiscal;
        this.num_notafiscal = num_notafiscal;
        this.id_cliente = id_cliente;
        this.id_empresa = id_empresa;
        this.id_servico = id_servico;
        this.cliente = cliente;
        this.empresa = empresa;
        this.ClienteLocker = ClienteLocker;
    }

    public NotaFiscal(String id_cliente, String id_empresa) {
        this.id_cliente = id_cliente;
        this.id_empresa = id_empresa;
    }

    public NotaFiscal(String num_notafiscal) {
        this.num_notafiscal = num_notafiscal;
    }

    public int getId_notafiscal() {
        return id_notafiscal;
    }

    public void setId_notafiscal(int id_notafiscal) {
        this.id_notafiscal = id_notafiscal;
    }

    public String getNum_notafiscal() {
        return num_notafiscal;
    }

    public void setNum_notafiscal(String num_notafiscal) {
        this.num_notafiscal = num_notafiscal;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ClienteLocker getClienteLocker() {
        return ClienteLocker;
    }

    public void setClienteLocker(ClienteLocker ClienteLocker) {
        this.ClienteLocker = ClienteLocker;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" + "id_notafiscal=" + id_notafiscal + ", num_notafiscal=" + num_notafiscal + ", id_cliente=" + id_cliente + ", id_empresa=" + id_empresa + ", id_servico=" + id_servico + ", cliente=" + cliente + ", empresa=" + empresa + ", ClienteLocker=" + ClienteLocker + '}';
    }
    
    
}
