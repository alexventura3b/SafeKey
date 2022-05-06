package safekey.model.bean;

public class ClienteLocker {

    private int id_contrato;
    private int num_contrato;
    private int id_cliente;
    private String id_veiculo;
    private int id_compartimento;
    private String dt_contrato;
    private String hora_contrato;
    private String obs_contrato;
    private int id_tarifa;
    private boolean status_contrato;
    private int id_pagamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Tarifa tarifa;
    private Pagamento pagamento;
    

    public ClienteLocker(int id_contrato, int num_contrato, int id_cliente, String id_veiculo, int id_compartimento, String dt_contrato, String hora_contrato, String obs_contrato, int id_tarifa, boolean status_contrato, int id_pagamento) {
        this.id_contrato = id_contrato;
        this.num_contrato = num_contrato;
        this.id_cliente = id_cliente;
        this.id_veiculo = id_veiculo;
        this.id_compartimento = id_compartimento;
        this.dt_contrato = dt_contrato;
        this.hora_contrato = hora_contrato;
        this.obs_contrato = obs_contrato;
        this.id_tarifa = id_tarifa;
        this.status_contrato = status_contrato;
        this.id_pagamento = id_pagamento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ClienteLocker(int num_contrato) {
        this.num_contrato = num_contrato;
    }

    public ClienteLocker(int id_cliente, String id_veiculo) {
        this.id_cliente = id_cliente;
        this.id_veiculo = id_veiculo;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getNum_contrato() {
        return num_contrato;
    }

    public void setNum_contrato(int num_contrato) {
        this.num_contrato = num_contrato;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(String id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public int getId_compartimento() {
        return id_compartimento;
    }

    public void setId_compartimento(int id_compartimento) {
        this.id_compartimento = id_compartimento;
    }

    public String getDt_contrato() {
        return dt_contrato;
    }

    public void setDt_contrato(String dt_contrato) {
        this.dt_contrato = dt_contrato;
    }

    public String getHora_contrato() {
        return hora_contrato;
    }

    public void setHora_contrato(String hora_contrato) {
        this.hora_contrato = hora_contrato;
    }

    public String getObs_contrato() {
        return obs_contrato;
    }

    public void setObs_contrato(String obs_contrato) {
        this.obs_contrato = obs_contrato;
    }

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public boolean isStatus_contrato() {
        return status_contrato;
    }

    public void setStatus_contrato(boolean status_contrato) {
        this.status_contrato = status_contrato;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    @Override
    public String toString() {
        return "ClienteLocker{" + "id_contrato=" + id_contrato + ", num_contrato=" + num_contrato + ", id_cliente=" + id_cliente + ", id_veiculo=" + id_veiculo + ", id_compartimento=" + id_compartimento + ", dt_contrato=" + dt_contrato + ", hora_contrato=" + hora_contrato + ", obs_contrato=" + obs_contrato + ", id_tarifa=" + id_tarifa + ", status_contrato=" + status_contrato + ", id_pagamento=" + id_pagamento + ", cliente=" + cliente + ", veiculo=" + veiculo + ", tarifa=" + tarifa + ", pagamento=" + pagamento + '}';
    }
    
}