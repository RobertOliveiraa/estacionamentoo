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
public class Carro {
    private Integer carcod;
    private String carplaca;
    private String carmarca;
    private String carmodelo;
    private String carcor;

    public Carro() {
    }

    public Integer getCarcod() {
        return carcod;
    }

    public void setCarcod(Integer carcod) {
        this.carcod = carcod;
    }

    public String getCarplaca() {
        return carplaca;
    }

    public void setCarplaca(String carplaca) {
        this.carplaca = carplaca;
    }

    public String getCarmarca() {
        return carmarca;
    }

    public void setCarmarca(String carmarca) {
        this.carmarca = carmarca;
    }

    public String getCarmodelo() {
        return carmodelo;
    }

    public void setCarmodelo(String carmodelo) {
        this.carmodelo = carmodelo;
    }

    public String getCarcor() {
        return carcor;
    }

    public void setCarcor(String carcor) {
        this.carcor = carcor;
    }
    
}
