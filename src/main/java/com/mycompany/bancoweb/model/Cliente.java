/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.model;

import java.util.Random;

/**
 *
 * @author luizlaljr
 */
public class Cliente {
    
    public static final int LOGADO = 1;
    public static final int DEPOSITAR = 1;
    public static final int SACAR = 2;
    public static final int PAGAR = 3;
    private int idcliente;
    private String nome;
    private String login;
    private String cpf;
    private String senha;
    private int conta;
    private float saldo;
    
    public Cliente(){
        super();
    }   

    @Override
    public String toString() {
        return "Cliente{" + "nome: " + nome + ", login: " + login + ", cpf:" + cpf + '}';
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public int generateConta(){
        int conta = 0;
        Random rd = new Random();
        conta = rd.nextInt(9999);
        return conta;
    }
}
