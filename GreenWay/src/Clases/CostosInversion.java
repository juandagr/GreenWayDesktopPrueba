/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class CostosInversion {
    
    String item;
    Double valor;

    public CostosInversion(String item, Double valor) {
        this.item = item;
        this.valor = valor;
    }

    public String getItem() {
        return item;
    }

    public Double getValor() {
        return valor;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    
    
}
