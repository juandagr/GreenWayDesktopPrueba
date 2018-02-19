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
    Double valorUnitario;
    String unidades;

    public CostosInversion(String item, Double valor, Double valorUnitario, String unidades) {
        this.item = item;
        this.valor = valor;
        this.valorUnitario = valorUnitario;
        this.unidades = unidades;
    }

    
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

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    
    
    
}
