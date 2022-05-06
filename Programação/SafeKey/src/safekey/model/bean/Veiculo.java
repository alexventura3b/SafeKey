package safekey.model.bean;

public class Veiculo {

    private int id_veiculo;
    private String placa;
    private Cliente cliente;
    private String marca;
    private String modelo;
    private String ano_fabr;
    private String cor;
    private String obs;

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno_fabr() {
        return ano_fabr;
    }

    public void setAno_fabr(String ano_fabr) {
        this.ano_fabr = ano_fabr;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id_veiculo=" + id_veiculo + ", \nplaca=" + placa + ", \ncliente=" + cliente + ", \nmarca=" + marca + ", \nmodelo=" + modelo + ", \nano_fabr=" + ano_fabr + ", \ncor=" + cor + ", \nobs=" + obs + '}';
    }

}
