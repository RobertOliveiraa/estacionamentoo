/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author RobertOliveira
 */
public class Reserva {
    
    private Integer rescod;
    private Carro carro;
    private Cliente cliente;
    private Double resvalor;
    private String resdthrent;
    private String resdthrsai;
    private String resdthrdur;
    private Double respagamento;
    private Double restroco;
    private String resestatus;
    
    public Reserva(){
        
    }

    public Integer getRescod() {
        return rescod;
    }

    public void setRescod(Integer rescod) {
        this.rescod = rescod;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getResvalor() {
        return resvalor;
    }

    public void setResvalor(Double resvalor) {
        this.resvalor = resvalor;
    }

    public String getResdthrent() {
        return resdthrent;
    }

    public void setResdthrent(String resdthrent) {
        this.resdthrent = resdthrent;
    }

    public String getResdthrsai() {
        return resdthrsai;
    }

    public void setResdthrsai(String resdthrsai) {
        this.resdthrsai = resdthrsai;
    }

    public String getResdthrdur() {
        return resdthrdur;
    }

    public void setResdthrdur(String resdthrdur) {
        this.resdthrdur = resdthrdur;
    }

    public Double getRespagamento() {
        return respagamento;
    }

    public void setRespagamento(Double respagamento) {
        this.respagamento = respagamento;
    }

    public Double getRestroco() {
        return restroco;
    }

    public void setRestroco(Double restroco) {
        this.restroco = restroco;
    }

    public String getResestatus() {
        return resestatus;
    }

    public void setResestatus(String resestatus) {
        this.resestatus = resestatus;
    }
    

}
