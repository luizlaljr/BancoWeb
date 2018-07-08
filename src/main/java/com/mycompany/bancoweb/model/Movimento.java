/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.model;

/**
 *
 * @author luizlaljr
 */
public class Movimento {
    
    private int id_mov;
    private int tipo_mov;
    private float valor;
    private int conta;

    public Movimento() {
    }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public int getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(int tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    
    
}
