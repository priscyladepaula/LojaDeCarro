package model;

/**
 *
 * @author priscyla.poliveira
 */
public class Produto {
    
    private int id, ano;
    private String modelo;
    private double valor;
    
    public Produto() {
    }

    public Produto(int id, int ano, double valor, String modelo) {
        this.ano = ano;
        this.id = id;
        this.valor = valor;
        this.modelo = modelo;
    }
    
    public Produto(int ano, double valor, String modelo) {
        this.ano = ano;
        this.valor = valor;
        this.modelo = modelo;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

}
