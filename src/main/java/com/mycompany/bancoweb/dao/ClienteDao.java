/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.dao;

import com.mycompany.bancoweb.connection.ConnectionFactory;
import com.mycompany.bancoweb.model.Cliente;
import com.mycompany.bancoweb.model.Movimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizlaljr
 */
public class ClienteDao {

    public boolean inserir(Cliente c) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "INSERT INTO dbdw.cliente (nome, login, cpf, senha, conta, saldo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        boolean inserido = true;
        criarTabelaCliente();
        criarTabelaMovimento();
        System.out.println("1");
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getLogin());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getSenha());
            System.out.println("2");
            int novaConta = c.generateConta();
            stmt.setInt(5, novaConta);
            stmt.setFloat(6, 0);
            System.out.println("3");
            stmt.executeUpdate();
            System.out.println("4");
        } catch (SQLException e) {
            System.out.println("Deu ruim na inserção!");
            inserido = false;
        } finally {
            conn.closeConnection();
        }
        return inserido;
    }

    public Cliente validar(String login, String senha) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "SELECT * FROM dbdw.cliente WHERE login=? AND senha=?";
        PreparedStatement stmt;
        ResultSet rs;
        Cliente cliente = null;
        try {

            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setConta(rs.getInt("conta"));
            }

        } catch (Exception e) {
            System.out.println("Deu ruim na validação!");
        } finally {
            conn.closeConnection();

        }
        return cliente;
    }

    public boolean contaDisponivel(int novaConta) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "SELECT conta FROM dbdw.cliente WHERE conta=?";
        PreparedStatement stmt;
        ResultSet rs;
        boolean resultado = true;

        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);

            stmt.setInt(1, novaConta);

            rs = stmt.executeQuery();

            if (rs.wasNull()||rs.next()) {
                resultado = false;
            }

        } catch (Exception e) {
            System.out.println("Deu ruim na busca de nova conta!");
        } finally {
            conn.closeConnection();

        }
        return resultado;
    }

    public Cliente buscar(String buscaCpf) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "SELECT * FROM dbdw.cliente WHERE cpf=?";
        PreparedStatement stmt;
        ResultSet rs;
        Cliente cliente = new Cliente();

        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);

            stmt.setString(1, buscaCpf);

            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente.setIdcliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setConta(rs.getInt("conta"));
            }

        } catch (Exception e) {
            System.out.println("Deu ruim na busca do cliente pelo CPF!");
        } finally {
            conn.closeConnection();

        }
        return cliente;
    }

    public void depositar(int conta, float valor) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "INSERT INTO dbdw.movimento (tipo_mov,valor,conta) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, Cliente.DEPOSITAR);
            stmt.setFloat(2, valor);
            stmt.setInt(3, conta);
            stmt.executeUpdate();
            atualizarSaldo(conta, Cliente.DEPOSITAR, valor);
        } catch (SQLException e) {
            System.out.println("Deu ruim no deposito!");
        } finally {
            conn.closeConnection();
        }
    }

    public void sacar(int conta, float valor) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "INSERT INTO dbdw.movimento (tipo_mov,valor,conta) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, Cliente.SACAR);
            stmt.setFloat(2, valor);
            stmt.setInt(3, conta);
            stmt.executeUpdate();
            atualizarSaldo(conta, Cliente.SACAR, valor);
        } catch (SQLException e) {
            System.out.println("Deu ruim no saque!");
        } finally {
            conn.closeConnection();
        }
    }
    public void pagar(int conta, float valor) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "INSERT INTO dbdw.movimento (tipo_mov,valor,conta) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, Cliente.PAGAR);
            stmt.setFloat(2, valor);
            stmt.setInt(3, conta);
            stmt.executeUpdate();
            atualizarSaldo(conta, Cliente.PAGAR, valor);
        } catch (SQLException e) {
            System.out.println("Deu ruim no pagamento!");
        } finally {
            conn.closeConnection();
        }
    }

    public void atualizarSaldo(int conta, int tipo_mov, float valor) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "UPDATE dbdw.cliente SET saldo = ? WHERE conta=?";
        PreparedStatement stmt;
        float saldoAtual;
        if (tipo_mov == Cliente.DEPOSITAR) {
            saldoAtual = saldo(conta) + valor;
        } else {
            saldoAtual = saldo(conta) - valor;
        }
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, saldoAtual);
            stmt.setInt(2, conta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu ruim na atualização do saldo!");
        } finally {
            conn.closeConnection();
        }
    }

    public float saldo(int conta) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "SELECT saldo FROM dbdw.cliente WHERE conta=?";
        PreparedStatement stmt;
        ResultSet rs;
        float saldo = 0;

        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);

            stmt.setInt(1, conta);

            rs = stmt.executeQuery();

            if (rs.next()) {
                saldo = rs.getFloat("saldo");
            }

        } catch (Exception e) {
            System.out.println("Deu ruim na busca do saldo do cliente!");
        } finally {
            conn.closeConnection();

        }
        return saldo;
    }
    
    public List<Movimento> extrato(int conta) {
        ConnectionFactory conn = new ConnectionFactory();
        String sql = "SELECT * FROM dbdw.movimento WHERE conta=?";
        PreparedStatement stmt;
        ResultSet rs;
        List<Movimento> extrato = new ArrayList<>();
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);

            stmt.setInt(1, conta);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Movimento mov = new Movimento();
                mov.setId_mov(rs.getInt("id_mov"));
                mov.setTipo_mov(rs.getInt("tipo_mov"));
                mov.setValor(rs.getFloat("valor"));
                mov.setConta(rs.getInt("conta"));
                extrato.add(mov);
            }

        } catch (Exception e) {
            System.out.println("Deu ruim no extrato do cliente!");
        } finally {
            conn.closeConnection();

        }
        return extrato;
    }
    public void criarTabelaCliente() {
        ConnectionFactory conn = new ConnectionFactory();
        PreparedStatement stmt;
        String sql = "CREATE TABLE IF NOT EXISTS `dbdw`.`cliente` (\n" +
                    "  `id_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                    "  `nome` varchar(100) NOT NULL,\n" +
                    "  `login` varchar(45) NOT NULL,\n" +
                    "  `cpf` varchar(14) NOT NULL,\n" +
                    "  `senha` varchar(6) NOT NULL,\n" +
                    "  `conta` int(11) NOT NULL,\n" +
                    "  `saldo` decimal(10,0) NOT NULL DEFAULT '0',\n" +
                    "  PRIMARY KEY (`id_cliente`),\n" +
                    "  UNIQUE KEY `cpf_UNIQUE` (`cpf`),\n" +
                    "  UNIQUE KEY `conta_UNIQUE` (`conta`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8";
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Deu ruim na criação da tabela cliente!");
        } finally {
            conn.closeConnection();

        }
        
    }
    
    public void criarTabelaMovimento() {
        ConnectionFactory conn = new ConnectionFactory();
        PreparedStatement stmt;
        String sql = "CREATE TABLE IF NOT EXISTS `dbdw`.`movimento` (\n" +
                    "  `id_mov` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `tipo_mov` int(11) NOT NULL,\n" +
                    "  `valor` decimal(10,0) NOT NULL,\n" +
                    "  `conta` int(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id_mov`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8";
        try {
            stmt = (PreparedStatement) conn.getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Deu ruim na criação da tabela movimento!");
        } finally {
            conn.closeConnection();

        }
        
    }
}
